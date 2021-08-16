public class TriangleCheck {
    public static String checkTriangle(int side1, int side2, int side3) {
        if(side1>0&&side2>0&&side3>0) {
            if(side1+side2>side3 && side1+side3>side2 && side2+side3>side1) {
                if(isEquilateralTriangle(side1,side2,side3)) {
                    return "Tam giac deu";
                }else if(isIsoscelesTriangle(side1,side2,side3)) {
                    return "Tam giac can";
                }else {
                    return "Tam giac thuong";
                }
            }else {
                return "Khong phai tam giac";
            }
        }else {
            return "Khong phai tam giac";
        }
    }
    public static boolean isIsoscelesTriangle(int side1, int side2, int side3) {
        boolean isIsoscelesTriangle = false;
        if(side1 == side2 || side2==side3 || side3==side1) {
            isIsoscelesTriangle = true;
        }
         return isIsoscelesTriangle;
    }
    public static boolean isEquilateralTriangle(int side1, int side2, int side3) {
        boolean isEquilateralTriangle = false;
        if(side1 == side2 && side2==side3) {
            isEquilateralTriangle = true;
        }
        return isEquilateralTriangle;
    }
}
