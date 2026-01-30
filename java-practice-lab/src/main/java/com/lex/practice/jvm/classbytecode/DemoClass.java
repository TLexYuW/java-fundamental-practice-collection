package com.lex.practice.jvm.classbytecode;

import java.io.Serializable;

/**
 * @author : LEX_YU
 * @date : 2023/3/11
 */
public class DemoClass implements Serializable {
    int x  = 1;
    void test(){}
}
/* javap -verbose DemoClass
cafe babe 0000 003d 0017 0a00 0200 0307
0004 0c00 0500 0601 0010 6a61 7661 2f6c
616e 672f 4f62 6a65 6374 0100 063c 696e
6974 3e01 0003 2829 5609 0008 0009 0700
0a0c 000b 000c 0100 2863 6f6d 2f6c 6578
2f70 7261 6374 6963 652f 636c 6173 7362
7974 6563 6f64 652f 4465 6d6f 436c 6173
7301 0001 7801 0001 4907 000e 0100 146a
6176 612f 696f 2f53 6572 6961 6c69 7a61
626c 6501 0004 436f 6465 0100 0f4c 696e
654e 756d 6265 7254 6162 6c65 0100 124c
6f63 616c 5661 7269 6162 6c65 5461 626c
6501 0004 7468 6973 0100 2a4c 636f 6d2f
6c65 782f 7072 6163 7469 6365 2f63 6c61
7373 6279 7465 636f 6465 2f44 656d 6f43
6c61 7373 3b01 0004 7465 7374 0100 0a53
6f75 7263 6546 696c 6501 000e 4465 6d6f
436c 6173 732e 6a61 7661 0021 0008 0002
0001 000d 0001 0000 000b 000c 0000 0002
0001 0005 0006 0001 000f 0000 0038 0002
0001 0000 000a 2ab7 0001 2a04 b500 07b1
0000 0002 0010 0000 000a 0002 0000 0009
0004 000a 0011 0000 000c 0001 0000 000a
0012 0013 0000 0000 0014 0006 0001 000f
0000 002b 0000 0001 0000 0001 b100 0000
0200 1000 0000 0600 0100 0000 0b00 1100
0000 0c00 0100 0000 0100 1200 1300 0000
0100 1500 0000 0200 16
 */
/*
$ javap -verbose DemoClass
Warning: File .\DemoClass.class does not contain class DemoClass
Classfile /D:/CodeWorkspace/Java/java-fundamental-practice/java-jvm-learning/target/classes/com/lex/practice/classbytecode/DemoClass.class
  Last modified 2023�~3��11��; size 441 bytes
  SHA-256 checksum 8b5a7305cb2e6a8e35c4ab250009f242898a08f81082cebe02cbe2405792c128
  Compiled from "DemoClass.java"
public class com.lex.practice.classbytecode.DemoClass implements java.io.Serializable
  minor version: 0
  major version: 61
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #8                          // com/lex/practice/classbytecode/DemoClass
  super_class: #2                         // java/lang/Object
  interfaces: 1, fields: 1, methods: 2, attributes: 1
Constant pool:
   #1 = Methodref          #2.#3          // java/lang/Object."<init>":()V
   #2 = Class              #4             // java/lang/Object
   #3 = NameAndType        #5:#6          // "<init>":()V
   #4 = Utf8               java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Fieldref           #8.#9          // com/lex/practice/classbytecode/DemoClass.x:I
   #8 = Class              #10            // com/lex/practice/classbytecode/DemoClass
   #9 = NameAndType        #11:#12        // x:I
  #10 = Utf8               com/lex/practice/classbytecode/DemoClass
  #11 = Utf8               x
  #12 = Utf8               I
  #13 = Class              #14            // java/io/Serializable
  #14 = Utf8               java/io/Serializable
  #15 = Utf8               Code
  #16 = Utf8               LineNumberTable
  #17 = Utf8               LocalVariableTable
  #18 = Utf8               this
  #19 = Utf8               Lcom/lex/practice/classbytecode/DemoClass;
  #20 = Utf8               test
  #21 = Utf8               SourceFile
  #22 = Utf8               DemoClass.java
{
  int x;
    descriptor: I
    flags: (0x0000)

  public com.lex.practice.classbytecode.DemoClass();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: aload_0
         5: iconst_1
         6: putfield      #7                  // Field x:I
         9: return
      LineNumberTable:
        line 9: 0
        line 10: 4
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      10     0  this   Lcom/lex/practice/classbytecode/DemoClass;

  void test();
    descriptor: ()V
    flags: (0x0000)
    Code:
      stack=0, locals=1, args_size=1
         0: return
      LineNumberTable:
        line 11: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       1     0  this   Lcom/lex/practice/classbytecode/DemoClass;
}
SourceFile: "DemoClass.java"
 */