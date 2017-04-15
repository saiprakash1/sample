from socket import *
from datetime import datetime
from array import array
import socket
import time,sys
clientsocket=socket.socket(AF_INET,SOCK_DGRAM)
#serverhost='192.168.0.12'
clienthost=sys.argv[1]
clientport=sys.argv[2]
serverhost=sys.argv[3]
serverport=sys.argv[4]
#clientsocket.bind(('192.168.0.12',5434))
clientsocket.bind((clienthost,int(clientport)))
var1='test'
#a=array('f',[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19])
list1=[]
i=0
sum=0.0
counter=0
loss_count=0
clientsocket.settimeout(1.0)
while counter<30:
   #print 'client pinger started'
   try:
    counter=counter+1
    a=time.time()  
    #clientsocket.sendto(var1,(serverhost,12000))
    clientsocket.sendto(var1,(serverhost,int(serverport)))
    #message,addr=clientsocket.recvfrom(5434)
    message,addr=clientsocket.recvfrom(int(clientport))
    b=time.time()
    c=b-a
    list1.insert(i,c)
    i=i+1    
    #a.insert(i,c)
   except timeout:
    print counter,' UNsuccessfull ping'
    loss_count=loss_count+1
    continue
   print counter,' Successfull ping, RTT =',c
   sum=sum+c
   print message
average=sum/30
loss_rate=((float(counter-loss_count)/30)*100)
print 'average RTT',average
print 'maximum RTT',max(list1)
print 'minimum RTT',min(list1)
print 'Success rate',loss_rate
clientsocket.close
