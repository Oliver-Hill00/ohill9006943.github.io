PLAN.md P0 TrafficAnimation - Oliver Hill

# Overview

Summarize the purpose of the program in 1-2 complete, well-written sentences. (NOT the purpose of the assignment. The purpose of the program.)

The purpose of the program is to visualize a 2D scenario of a vehicle crossing the road, with a pedestrian as a viewer in front. This program helps demonstrate the skills of using java.util import packages to use colors, shapes, and coordinates to make an image come to life with the code used to make and import other images and files. I will be able to use already learned topics such as classes, methods, arguments, and objects to complete the code in a well formatted and correct coding sequence.

# Program Requirements

In your own words, outline the program requirements and identify key programming concepts/skills from current and prior modules that must be applied to achieve those requirements.

The program requiremments are:

1. Draw a vehicle with reference to a common anchor point found in the image (x,y).
2. Vehicle must have a minimum of a cab, body, and two wheels
3. Vehcile drawn must scale properly when window is varied in size per user ability
4. Vehicle should bounce between left and right edge of screen.
5. Draw a lane on the road that the vehicle can use as a reference point when moving side to side
6. Draw an avatar observer on the side of the road that is waiting to cross but can visually notice the vehicle on the road
7. Use at least 5 different methods from the graphics class ie (draw, fill, types of shapes, etc)
8. Display text in the window that sizes correctly to window
9. Use minimum three colors in the overall scene.
10. Scene must be resized appropriately when user drags window
11. Provide description of project in beginning of java.doc that outlines purpose of assignment
12. Pay attention to consistency when coding, using correct punctuation, grammar, and using whitespace correctly

# Concept References

Identify the slides (module and slide numbers) that introduce and demonstrate each of the following concepts:
 * declaring, initializing, and accessing variables - Module 1 Slides 53 - 56, Module 3 Slides 20,22
 * declaring, initializing, and accessing constants - Module 1 Slides 61
 * arithmetic expressions for calculating new values - Module 2 Slides 16 - 32, Module 3 Slides 69,72
 * declaring and referencing Colors - Module 3 Slides 41
 * Graphics drawing methods - Module 3 Slides 36,43-46

# Activity Connections

Scaling dimensions of Graphics shapes using multiples (or fractions) of a unit dimension calculated based on current window size is a central concept of this project. Give examples from the MiniFig and Geocentric Orbit activities where you scaled something based on another "unit dimension" based on the current window size.

MiniFig:

Scaled knob dimensions:
1. knobWidth = (int) (40 * scaleFactor);
2. knobHeight = (int) (16 * scaleFactor);
3. knobCurve = Math.min(5, (int) (5 * scaleFactor));
Scaling the torso:
4. torsoShoulderWidth = (int) (90 * scaleFactor);
5. torsoWaistWidth = (int) (130 * scaleFactor);
6. torsoHeight = (int) (114 * scaleFactor);

Geocentric Orbit:

Scaling Earth size in conjunction with set window size:
1. int earthRadius = Math.min(width / 5, height / 5);
2. int earthX = width / 2;
3. int earthY = height / 2;
Scaling Orbit radius in conjuction with set window size:
4. int orbitRadius = Math.min(earthX / 2, earthY / 2);

Positioning Graphics shapes relative to calculated "anchor points", based either on a current window dimension or another already-established point in the window is a central concept of this project. Give examples from the MiniFig and Geocentric Orbit activities where you calculated the location of one shape based on another calculated location. How did the dimensions of the shape being drawn play into the calculations of its position?

MiniFig:
1. int leftEyeXOffset = mid - (eyeSpacing / 2 + eyeDiameter / 2);
2. int rightEyeXOffset = mid + (eyeSpacing / 2 - eyeDiameter / 2);
3. int EyeYOffset = faceAnchor.y + eyeDistFromTopOfFace;
4. faceAnchor = new Point(mid - faceWidth / 2, top + knobHeight);

Geocentric Orbit:
1. int objectX = (int) (earthX + orbitRadius * Math.cos(Math.toRadians(orbitTheta)));
2. int objectY = (int) (earthY + orbitRadius * Math.sin(Math.toRadians(orbitTheta)));
3. page.fillOval(objectX - objectRadius, objectY - objectRadius, objectRadius * 2, objectRadius * 2);

Analysis:
1. The dimensions of the shape we drawn into play by being used to calculate the positioning of the miniFig and the object around earths orbit and to ensure the figures proper alignment when scaling the image based on the appropriate window size. This can be said when positioning the head to the minifigures' body, or the object to the center of the earth.


# Testing Plan

How will you test this program during development to ensure it meets all requirements? How will you know your program has met all requirements?

1. I will test this program during development a couple of lines at a time, and when I test I will notate down what code segment worked with the proper comments from java.doc comment structure. I
will also test each sections seperately by commenting out parts of the code that I will not want to run at the same time. In the end I will allow all code to be ran at the same time, and figure out the necessary scaling that is needed based on any anchor point variables that I make in the program itself, within private classes that I will use in the overall constructor when I am completeing the program by the required due date.

# Compile and Run Instructions

From the directory containing all source code (.java) files, what is the command-line command that compiles the program?

1. The command-line that compiles the program is the javac command, which can be used with javac *.java to run all associated programs inside of constructor.

From the directory containing the compiled class (.class) files, what is the command-line command that runs the program?

2. To run the required program, we can use the java command followed by the name of the overall Main class, but to make sure that we do not follow it with the .class extension.

Provide any additional instructions the user needs beyond the run command to run the program.

1. Use the -cp command to set a class path for the desired java file, so the source code has a destination that we can pull code from
2. We can also use the pwd command to check the file pathway and check to see if our other files have the correct file destination.
3. If the string args [] method is used, we can pass command line arguments directly after the specified class name in our code.
4. The working directory can be found by accessing the -cp command and tying it in with the bin identifier to determine if the pathway of the class is correct.
5. Set up environment variables to use Java specified commands with more simplicity
6. Check the version of Java on your terminal to make sure the commands operate correctly and the packages are installed with the correct versions.







# Review & Reflect
Complete your reflection after the project has been completed.

Write a two to three paragraph reflection describing your experience with this project. Talk about what worked well and what didn't work so well in planning, coding, and testing.  Did you run into an issue that took some time to figure out?  Tell us about it.
