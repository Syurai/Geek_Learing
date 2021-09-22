--当前class文件的基本信息
--修改时间和文件大下
Classfile /C:/Users/syurai/Geek_Learning/week1/task1/Hello.class
  Last modified 2021-9-18; size 1163 bytes
  MD5 checksum 309265fecab622a62499c30867f151e2
  Compiled from "Hello.java"
  
--当前class文件的版本号和修饰符
--版本号：52.0（52对应的是JDK8）
--修饰符：PUBLIC（SUPER指的是父类） 
public class Hello
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
  
--常量池
Constant pool:
   #1 = Methodref          #21.#46        // java/lang/Object."<init>":()V
   #2 = Double             2.0d
   #4 = Long               3l
   #6 = String             #47            //
   #7 = Methodref          #48.#49        // java/lang/String.length:()I
   #8 = Fieldref           #50.#51        // java/lang/System.out:Ljava/io/PrintStream;
   #9 = Class              #52            // java/lang/StringBuilder
  #10 = Methodref          #9.#46         // java/lang/StringBuilder."<init>":()V
  #11 = String             #53            // 错误用法: num2 + num3 =
  #12 = Methodref          #9.#54         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #13 = Methodref          #9.#55         // java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
  #14 = Methodref          #9.#56         // java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
  #15 = Methodref          #9.#57         // java/lang/StringBuilder.toString:()Ljava/lang/String;
  #16 = Methodref          #58.#59        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #17 = String             #60            // 四则运算: num1 * num4 =
  #18 = Methodref          #58.#61        // java/io/PrintStream.print:(Ljava/lang/String;)V
  #19 = Methodref          #58.#62        // java/io/PrintStream.println:(I)V
  #20 = Class              #63            // Hello
  #21 = Class              #64            // java/lang/Object
  #22 = Utf8               <init>
  #23 = Utf8               ()V
  #24 = Utf8               Code
  #25 = Utf8               LineNumberTable
  #26 = Utf8               LocalVariableTable
  #27 = Utf8               this
  #28 = Utf8               LHello;
  #29 = Utf8               main
  #30 = Utf8               ([Ljava/lang/String;)V
  #31 = Utf8               i
  #32 = Utf8               I
  #33 = Utf8               args
  #34 = Utf8               [Ljava/lang/String;
  #35 = Utf8               num1
  #36 = Utf8               num2
  #37 = Utf8               D
  #38 = Utf8               num3
  #39 = Utf8               J
  #40 = Utf8               num4
  #41 = Utf8               B
  #42 = Utf8               StackMapTable
  #43 = Class              #34            // "[Ljava/lang/String;"
  #44 = Utf8               SourceFile
  #45 = Utf8               Hello.java
  #46 = NameAndType        #22:#23        // "<init>":()V
  #47 = Utf8
  #48 = Class              #65            // java/lang/String
  #49 = NameAndType        #66:#67        // length:()I
  #50 = Class              #68            // java/lang/System
  #51 = NameAndType        #69:#70        // out:Ljava/io/PrintStream;
  #52 = Utf8               java/lang/StringBuilder
  #53 = Utf8               错误用法: num2 + num3 =
  #54 = NameAndType        #71:#72        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #55 = NameAndType        #71:#73        // append:(D)Ljava/lang/StringBuilder;
  #56 = NameAndType        #71:#74        // append:(J)Ljava/lang/StringBuilder;
  #57 = NameAndType        #75:#76        // toString:()Ljava/lang/String;
  #58 = Class              #77            // java/io/PrintStream
  #59 = NameAndType        #78:#79        // println:(Ljava/lang/String;)V
  #60 = Utf8               四则运算: num1 * num4 =
  #61 = NameAndType        #80:#79        // print:(Ljava/lang/String;)V
  #62 = NameAndType        #78:#81        // println:(I)V
  #63 = Utf8               Hello
  #64 = Utf8               java/lang/Object
  #65 = Utf8               java/lang/String
  #66 = Utf8               length
  #67 = Utf8               ()I
  #68 = Utf8               java/lang/System
  #69 = Utf8               out
  #70 = Utf8               Ljava/io/PrintStream;
  #71 = Utf8               append
  #72 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
  #73 = Utf8               (D)Ljava/lang/StringBuilder;
  #74 = Utf8               (J)Ljava/lang/StringBuilder;
  #75 = Utf8               toString
  #76 = Utf8               ()Ljava/lang/String;
  #77 = Utf8               java/io/PrintStream
  #78 = Utf8               println
  #79 = Utf8               (Ljava/lang/String;)V
  #80 = Utf8               print
  #81 = Utf8               (I)V
{
  --构造函数
  public Hello();
    --参数和返回值
    descriptor: ()V
	--修饰符
    flags: ACC_PUBLIC
	--字节码
    Code:
	  --栈的深度是1，本地变量表的长度是1，参数是1
      stack=1, locals=1, args_size=1
	     --将变量表里的第一个引用类型变量load到栈上
         0: aload_0
		 --调用需要特殊处理的实例方法
		 --#1 = Methodref          #21.#46        // java/lang/Object."<init>":()V
		 --调用Object类里的init方法
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
		 --返回指令
         4: return
	  --行号表，表示第0个指令出现在代码的第一行	  
      LineNumberTable:
        line 1: 0
	  --本地变量表
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LHello;

  --main函数
  public static void main(java.lang.String[]);
    --参数和返回值
    descriptor: ([Ljava/lang/String;)V
	--修饰符
    flags: ACC_PUBLIC, ACC_STATIC
	--字节码
    Code:
	  --栈的深度是4，本地变量表的长度是8，参数是1
      stack=4, locals=8, args_size=1
	     --将 int 型 1 推送至栈顶
         0: iconst_1
		 --将栈顶 int 型数值存入第二个本地变量
         1: istore_1
		 --将 long 或 double 型常量值从常量池中推送至栈顶
		 --#2 = Double             2.0d
         2: ldc2_w        #2                  // double 2.0d
		 --将栈顶 double 型数值存入第三个本地变量
         5: dstore_2
		 --将 long 或 double 型常量值从常量池中推送至栈顶
		 --#4 = Long               3l
         6: ldc2_w        #4                  // long 3l
		 --将栈顶 long 型数值存入指定本地变量
         9: lstore        4
		--将 int 型 4 推送至栈顶
        11: iconst_4
		--将栈顶 int 型数值存入指定本地变量
        12: istore        6
		--将 int,float 或 String 型常量值从常量池中推送至栈顶
		--#6 = String             #47
		--#47 = Utf8
        14: ldc           #6                  // String
		--调用实例方法
		--#7 = Methodref          #48.#49        // java/lang/String.length:()I
		--#48 = Class              #65            // java/lang/String
		--#49 = NameAndType        #66:#67        // length:()I
        16: invokevirtual #7                  // Method java/lang/String.length:()I
		--将单字节的常量值 (-128~127) 推送至栈顶
        19: bipush        10
		--比较栈顶两 int 型数值大小，当结果大于等于 0 时跳转
        21: if_icmpge     54
		--获取指定类的静态域，并将其值压入栈顶
		--#8 = Fieldref           #50.#51        // java/lang/System.out:Ljava/io/PrintStream;
		--#50 = Class              #68            // java/lang/System
		--#68 = Utf8               java/lang/System
		--#51 = NameAndType        #69:#70        // out:Ljava/io/PrintStream;
		--#69 = Utf8               out
		--#70 = Utf8               Ljava/io/PrintStream;
        24: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
		--创建一个对象，并将其引用值压入栈顶
		--#9 = Class              #52            // java/lang/StringBuilder
		--#52 = Utf8               java/lang/StringBuilder
        27: new           #9                  // class java/lang/StringBuilder
		--复制栈顶数值并将复制值压入栈顶
        30: dup
		--调用需要特殊处理的实例方法
		--#10 = Methodref          #9.#46         // java/lang/StringBuilder."<init>":()V
		--#9 = Class              #52            // java/lang/StringBuilder
		--#52 = Utf8               java/lang/StringBuilder
		--#46 = NameAndType        #22:#23        // "<init>":()V
		--#22 = Utf8               <init>
		--#23 = Utf8               ()V
		--调用StringBuilder的init方法
        31: invokespecial #10                 // Method java/lang/StringBuilder."<init>":()V
		--将 int,float 或 String 型常量值从常量池中推送至栈顶
		--#11 = String             #53
		--#53 = Utf8               错误用法: num2 + num3 =
        34: ldc           #11                 // String 错误用法: num2 + num3 =
		--调用实例方法
		--#12 = Methodref          #9.#54         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
		--#9 = Class              #52            // java/lang/StringBuilder
		--#52 = Utf8               java/lang/StringBuilder
		--#54 = NameAndType        #71:#72        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
		--#71 = Utf8               append
		--#72 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
        36: invokevirtual #12                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        --将第三个 double 型本地变量推送至栈顶
		39: dload_2
		--调用实例方法
		--#13 = Methodref          #9.#55         // java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
		--#9 = Class              #52            // java/lang/StringBuilder
		--#52 = Utf8               java/lang/StringBuilder
		--#55 = NameAndType        #71:#73        // append:(D)Ljava/lang/StringBuilder;
		--#71 = Utf8               append
		--#73 = Utf8               (D)Ljava/lang/StringBuilder;
        40: invokevirtual #13                 // Method java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
        --将指定的 long 型本地变量推送至栈顶
		43: lload         4
        --调用实例方法
		--#14 = Methodref          #9.#56         // java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
		--#9 = Class              #52            // java/lang/StringBuilder
		--#52 = Utf8               java/lang/StringBuilder
		--#56 = NameAndType        #71:#74        // append:(J)Ljava/lang/StringBuilder;
		--#71 = Utf8               append
		--#74 = Utf8               (J)Ljava/lang/StringBuilder;
		45: invokevirtual #14                 // Method java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        --调用实例方法
		--#15 = Methodref          #9.#57         // java/lang/StringBuilder.toString:()Ljava/lang/String;
		--#9 = Class              #52            // java/lang/StringBuilder
		--#52 = Utf8               java/lang/StringBuilder
		--#57 = NameAndType        #75:#76        // toString:()Ljava/lang/String;
		--#75 = Utf8               toString
		--#76 = Utf8               ()Ljava/lang/String;
		48: invokevirtual #15                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        --调用实例方法
		--#16 = Methodref          #58.#59        // java/io/PrintStream.println:(Ljava/lang/String;)V
		--#58 = Class              #77            // java/io/PrintStream
		--#77 = Utf8               java/io/PrintStream
		--#59 = NameAndType        #78:#79        // println:(Ljava/lang/String;)V
		--#78 = Utf8               println
		--#79 = Utf8               (Ljava/lang/String;)V
		51: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        --将 int 型 0 推送至栈顶
		54: iconst_0
		--将栈顶 int 型数值存入指定本地变量
        55: istore        7
		--将指定的 int 型本地变量推送至栈顶
        57: iload         7
		--将第二个 int 型本地变量推送至栈顶
        59: iload_1
		--比较栈顶两 int 型数值大小，当结果大于等于 0 时跳转
        60: if_icmpge     87
		--获取指定类的静态域，并将其值压入栈顶
		--#8 = Fieldref           #50.#51        // java/lang/System.out:Ljava/io/PrintStream;
		--#50 = Class              #68            // java/lang/System
		--#68 = Utf8               java/lang/System
		--#51 = NameAndType        #69:#70        // out:Ljava/io/PrintStream;
		--#69 = Utf8               out
		--#70 = Utf8               Ljava/io/PrintStream;
        63: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
		--将 int,float 或 String 型常量值从常量池中推送至栈顶
		--#17 = String             #60
		--#60 = Utf8               四则运算: num1 * num4 =
        66: ldc           #17                 // String 四则运算: num1 * num4 =
        --调用实例方法
		--#18 = Methodref          #58.#61        // java/io/PrintStream.print:(Ljava/lang/String;)V
		--#58 = Class              #77            // java/io/PrintStream
		--#77 = Utf8               java/io/PrintStream
		--#61 = NameAndType        #80:#79        // print:(Ljava/lang/String;)V
		--#80 = Utf8               print
		--#79 = Utf8               (Ljava/lang/String;)V
		68: invokevirtual #18                 // Method java/io/PrintStream.print:(Ljava/lang/String;)V
        --获取指定类的静态域，并将其值压入栈顶
		--#8 = Fieldref           #50.#51        // java/lang/System.out:Ljava/io/PrintStream;
		--#50 = Class              #68            // java/lang/System
		--#68 = Utf8               java/lang/System
		--#51 = NameAndType        #69:#70        // out:Ljava/io/PrintStream;
		--#69 = Utf8               out
		--#70 = Utf8               Ljava/io/PrintStream;
		71: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
        --将第二个 int 型本地变量推送至栈顶
		74: iload_1
        --将指定的 int 型本地变量推送至栈顶
		75: iload         6
		--将栈顶两 int 型数值相乘并将结果压入栈顶
        77: imul
		--调用实例方法
		--#19 = Methodref          #58.#62        // java/io/PrintStream.println:(I)V
		--#58 = Class              #77            // java/io/PrintStream
		--#77 = Utf8               java/io/PrintStream
		--#62 = NameAndType        #78:#81        // println:(I)V
		--#78 = Utf8               println
		#81 = Utf8               (I)V
        78: invokevirtual #19                 // Method java/io/PrintStream.println:(I)V
        --将指定 int 型变量增加指定值（i++,i--,i+=2）
		81: iinc          7, 1
        --无条件跳转
		84: goto          57
        --从当前方法返回void
		87: return
	  --行号表
      LineNumberTable:
        line 3: 0
        line 4: 2
        line 5: 6
        line 6: 11
        line 7: 14
        line 9: 24
        line 11: 54
        line 13: 63
        line 14: 71
        line 11: 81
        line 16: 87
	  --本地变量表
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
           57      30     7     i   I
            0      88     0  args   [Ljava/lang/String;
            2      86     1  num1   I
            6      82     2  num2   D
           11      77     4  num3   J
           14      74     6  num4   B
      StackMapTable: number_of_entries = 3
        frame_type = 255 /* full_frame */
          offset_delta = 54
          locals = [ class "[Ljava/lang/String;", int, double, long, int ]
          stack = []
        frame_type = 252 /* append */
          offset_delta = 2
          locals = [ int ]
        frame_type = 250 /* chop */
          offset_delta = 29
}
SourceFile: "Hello.java"