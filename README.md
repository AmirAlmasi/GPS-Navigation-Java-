# About
The use of GPS navigation software is increasingly used to guide drivers to their 
desired destination, not the least by taxi drivers. That's not the only use for a GPS though. 
Many smartphones now include GPS to provide guidance, and it's also used for Geocaching, a “high-tech treasure hunting game”
where you navigate and try to find treasures, called geocaches, outdoors and indoors and then share your experiences.

# Requirements of the project
The project team shall deliver a GPS navigation software based on the GPSMAP 62st 
including modifications by the team, such as creative additions and improvements. In 
addition to this, the project team shall deliver a requirement specification and a design 
specification for the system under construction. The design shall be implemented, and 
result in working and tested software.
The functional requirements are at a minimum that the navigation system:
• should be able to read a set of geocache coordinates from a provided LOC file4
,
4 See http://www.cachemaps.com/Loc-syntax.htm for a description of the LOC file format.
Page 3 of 11• should be able to navigate the user to any of the geocache locations in the LOC 
file,
• should be able to guide the user around buildings, fences, and other obstacles.
Make sure you provide and include the following:
• A software requirement specification
• A design specification, including class diagrams and use case realisations
• Implemented design resulting in a working and tested software prototype that 
meets the above requirements
• Product and sprint backlogs that adequately record the team’s work
While you are allowed to use existing code or open source applications, you must 
write a substantial part of the code in the project yourself and clearly label your 
contributions as such.

# Software
The software needs to be written in Java, but you're invited to use whichever tool you 
feel most comfortable with in the team.

# Author
Amir Almasi <amir.fireflame@gmail.com>

# Licensing
It is a free software. you will find more information about the license in the license file.
# Pre conditions of software 
**************** Pre conditions of usage ***************************
The system should be connected to the Internet, and the GPS unit should be plugged into the computer. 
***How to find the shortest path from current location of the system*** 
If the sign of the mouse shows a hand on the map, there could be a path to this point from the current 
location of the system which would be shown if the user clicks on that point.

# How to tun the software on Linux 
******************** HOW TO INSTALL FOR LINUX **********************
This section is specifically for how to run the software on the Linux platform. Please note that  
the software can only be run on windows and Linux operative systems. Any attempt on running the 
software on a  
Mac operative system may result in complete failure and/or some parts of the software to not run 
properly. 
The software will run good on Linux, however the things that you as a user have to do, in order to 
receive  
coordinates and your position on the map is as follows: 
open the Linux file and choose i686-unknown-linux-gnu. Inside of it you will find : 
librxtxParallel.so 
librxtxSerial.so 
Copy these files inside /usr/java/j2sdk1.4.0/jre/lib/i386/ 
You can also choose a different librxtxSerial.so depending on what system you are running as available 
inside of Linux file.
FINAL STEP: 
now copy the RXTXcomm.jar into the following link /usr/java/j2sdk1.4.0/jre/lib/ext/ 
the file path may vary on your computer so please adjust it accordingly. 
# How to tun the software on Windows
***************** HOW TO INSTALL FOR WINDOWS **********************
Same as Linux, the only setting that has to be made is for the receiving of coordinates. 
the system will work properly after the following settings: 
Choose your binary build - x64 or x86 (based on which version of 
the JVM you are installing to) 
NOTE: You MUST match your architecture.  You can't install the i386 
version on a 64-bit version of the JDK and vice-versa. 
For a JDK installation: 
Copy RXTXcomm.jar ---> <JAVA_HOME>\jre\lib\ext 
Copy rxtxSerial.dll ---> <JAVA_HOME>\jre\bin 
Copy rxtxParallel.dll ---> <JAVA_HOME>\jre\bin 

# Software features:
********************* How to show Geocaches ************************
By pressing the button “Show LOC file”, the Geocaches would be shown on the map. If the button 
“Navigate to LOC file” is pressed, the number related to that Geocache would be asked, and if the user 
provides this number, the best way to that point would be shown. 
 
Note: If the user wishes to be directed to any of the Geocaches, he should click on that point so that 
related sounds and features would be set for him and the program would lead him to that point.   
 
*************** How to Save and Load the locations ****************
For saving: 
 Go to the top menu, select file ---> select Save. 
For Loading: 
 Either Go to the top menu, select file ---> select Load or 
 Select Load from the bottom of the screen.   
 
************** How to change the color of the theme **************
Go to Setting on the top menu, select “Theme Color”. 
 
****************** How to get help *******************************
Go to the top menu, select “help”. 
 
******************* How to Exit the program **********************
Go to File on the top menu, select “Exit”.