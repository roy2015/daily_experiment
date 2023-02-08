1. 运行
   修改client/server两个类的main方法，修改文件路径， client端还要修改server的ip。
   然后run server, client即可
2. 设计思路
  1) client/server 采用jdk NIO, socket channel通信
  2) zero-copy, 传文件收文件时 FileChannel和socketChannel直接transferTo, transferFrom， 
     传输文件大小信息和开始传输信号除外。
  3) client- server交互
     1) client-server建立connection后, client端向server发送要传输的文件大小fileLen
     2) server端收到fileLen后保存变量值，向client端发送开始信号"start"，转入接收文件监听事件
     3) client收到"start"后，发送文件
     注：server循环接收文件字节流，直到接收字节数达到fileLen后关闭通道channel，fileChannel，clientd端亦然   
     
