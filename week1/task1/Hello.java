public class Hello {
    public static void main(String[] args) {
        int num1 = 1;       // ������1;
        double num2 = 2.0D; // ��Сд��D������
        long num3 = 3L;     // ��Сд��L������, ��L�Ǻ�ϰ��;
        byte num4 = 4;      // ����ֱ�Ӹ��� [-128, 127] ��Χ�ڵ�������;
        if ("".length() < 10) {
            // �����÷�: num2 + num3 = 2.03
            System.out.println("�����÷�: num2 + num3 = " + num2 + num3);
        }
        for (int i = 0; i < num1; i++) {
            // ��������: num1 * num4 = 4
            System.out.print("��������: num1 * num4 = ");
            System.out.println(num1 * num4);
        }
    }
}