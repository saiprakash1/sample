#!/usr/bin/python
from socket import *
import socket,sys
import time
s=socket.socket(AF_INET,SOCK_DGRAM)
hostname=socket.gethostname() 
port=12346
port2=sys.argv[1]
print "Server is ready to receive messages"
s.bind(('',int(port2)))
while True:
   c,addr=s.recvfrom(2048) 
   b=c.upper()
   print "upper case converted in server  :",b
   temp1=addr[0]
   temp2=addr[1]
   temp=" message sent from server"
   d=b+temp
   s.sendto(d,(temp1,int(temp2)))
   del d
s.close()

