# We will need the following module to generate randomized lost packets
import random
from socket import *
import socket,sys
# Create a UDP socket
# Notice the use of SOCK_DGRAM for UDP packets
serverSocket = socket.socket(AF_INET,SOCK_DGRAM)
#host=sys.arg[1]
host=socket.gethostname()
print host
port=sys.argv[1]
# Assign IP address and port number to socket
#serverSocket.bind(('192.168.0.12', 12000))
serverSocket.bind((host, int(port)))
while True:
 print 'server pinger started'   
 # Generate random number in the range of 0 to 10
 rand = random.randint(0, 10)
 print 'Random number generated',rand
 # Receive the client packet along with the address it is coming from
 message, address = serverSocket.recvfrom(int(port))
 print message,address
 # Capitalize the message from the client
 message = message.upper()
 # If rand is less is than 2, we consider the packet lost and do not respond
 if rand < 5:
  print 'Packet lost'
  continue
 # Otherwise, the server responds
 serverSocket.sendto(message, address)
 #print 'PING is Successfull'
