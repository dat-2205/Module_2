package com.codegym;

import java.lang.invoke.MethodHandle;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class MaterialManagement implements discount{
    public Material[] materials ;

    public MaterialManagement(int size) {
        this.materials = new Material[size];
    };

    public MaterialManagement(Material[] materials) {
        this.materials = materials;
    }

    public Material[] getMaterials() {
        return materials;
    }

    public void setMaterials(Material[] materials) {
        this.materials = materials;
    }

    public Material getMaterialInfor(Material material,int number,Scanner sc) {
        System.out.println("Enter kind of material 1.Flour 2.Meat ");
        int kind = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter "+(number)+" a id: ");
        String id = sc.nextLine();
        System.out.println("Enter "+(number)+" a name: ");
        String name = sc.nextLine();
        System.out.println("Enter "+(number)+" cost: ");
        int cost = sc.nextInt();
        switch (kind) {
            case 1:
                System.out.println("Enter "+(number)+" quantity: ");
                int quantity = sc.nextInt();
                System.out.println("Enter "+(number)+" expiry: ");
                int expiry = sc.nextInt();
                Material crispyFlour = new CrispyFlour(id,name,cost,quantity,expiry);
                 material = crispyFlour;
                break;
            case 2:
                System.out.println("Enter "+(number)+" weight: ");
                double weight = sc.nextDouble();
                Material meat = new Meat(id,name,cost,weight);
                material = meat;
                break;
            default:
                System.out.println("Loai khong hop le!");
        }
        return material;
    }

    public void inputMaterial(int size,Scanner sc) {
        Material[] materials = new Material[size];
        for(int i=0;i<size;i++) {
            materials[i] = getMaterialInfor(materials[i],i,sc);
            }
        this.materials = materials;
    }

    public void showMaterial() {
        for(Material element : this.materials ){
            System.out.println(element);
        }
    }

    public void showAMaterial(String id) {
        int index = findMaterial(id);
        System.out.println(materials[index].toString());
    }

    public void addMaterial(int index,Scanner sc) {
        Material[] newMaterials = new Material[materials.length + 1];
        for(int i=0;i<newMaterials.length;i++) {
            if(i<index) {
                newMaterials[i] = materials[i];
            }else if(i==index) {
                newMaterials[i] = getMaterialInfor(materials[i],i,sc);
            }else if(i>index) {
                newMaterials[i] = materials[i-1];
            }
        }
        this.materials = newMaterials;
    }

    public void deleteMaterial(int index,Scanner sc) {
        Material[] newMaterials = new Material[materials.length - 1];
        for(int i=0;i<newMaterials.length;i++) {
            if(i<index) {
                newMaterials[i] = materials[i];
            }else if(i>=index) {
                newMaterials[i] = materials[i+1];
            }
        }
        this.materials = newMaterials;
    }

    public void refactorMaterial(int index,Scanner sc) {
        Material newMaterial = getMaterialInfor(materials[index],index,sc);
        materials[index] = newMaterial;
    }

    public long getDayLeft(Material material) {
        long dayLeft = ChronoUnit.DAYS.between(LocalDate.now(), material.getExpiryDate());
        return dayLeft;
    }

    public double getPrice(Material material,long dayLeft) {
        double amount = 0;
        double price = material.getAmount();
        if (dayLeft<=3) {
            amount = price - (price*50)/100;
        }else if(dayLeft<=5){
            amount = price - (price*30)/100;
        }else {
            amount = price - (price*10)/100;
        }
        return amount;
    }

    public int findMaterial(String id) {
        int index = -1;
        for(int i=0;i<materials.length;i++){
            if(materials[i].getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public double getRealMoney(Scanner sc,String id) {
        double realMoney = 0;
        int index = findMaterial(id);
        if(index >=0){
            long dayLeft = getDayLeft(materials[index]);
            realMoney = getPrice(materials[index],dayLeft);
        }else {
            System.out.println("Id khong hop le!");
        }
        return realMoney;
    }

    @Override
    public String toString() {
        return "MaterialManagement{" +
                "materials=" + Arrays.toString(materials) +
                '}';
    }
}
