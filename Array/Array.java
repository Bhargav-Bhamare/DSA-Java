class Array{
    public static void main(String[] args){
        int marks[]= new int[50];
        
        marks[0] = 98;
        marks[1] = 92;
        marks[2] = 89;
        
        System.out.println("Physics Marks = "+ marks[0]);
        System.out.println("Chem Marks = "+ marks[1]);
        System.out.println("Maths Marks = "+ marks[2]);
    }
}

class Array1{
    public static void updateMarks(int marks[]){
        for(int i=0;i<marks.length;i++){
            marks[i]=marks[i]+1;
        }
    }
    public static void main(String[] args){
        int marks[]= {98,99,95};
        updateMarks(marks);
        for(int i=0;i<marks.length;i++){
            System.out.println(marks[i]+" ");
        }
        System.out.println();
    }
}