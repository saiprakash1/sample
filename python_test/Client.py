#! /usr/bin/python
from socket import *
import socket,struct
import time,sys
s=socket.socket(AF_INET,SOCK_DGRAM)
port=sys.argv[1] #12345
host1=sys.argv[2]
port2=sys.argv[3]
print port, host1, port2
s.bind((host1,int(port)))
for var in range(1,6):
  print "In client for loop #",var
  var1=raw_input("enter something here in client for loop:")
  s.sendto(var1,(host1,int(port2)))
  c,addr=s.recvfrom(2048)
  print "message received from server # ",c
s.close

