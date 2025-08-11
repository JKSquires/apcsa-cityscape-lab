# apcsa-cityscape-lab
A lab in my AP Computer Science class where we had to design, build, and animate a city using different classes.

**Note: if you are a student looking to swipe this code for yourself, don't :)** (although, feel free to take inspiration from it; we can all help each other learn and grow!)

![gif of the cityscape animation](image.gif)

---

## Build Instructions

Run the following:
```sh
javac -verbose -d build src/*.java
cd build
jar cvfe cityscape_lab.jar CityscapeViewer *.class
```
The executable jar will be located in the `build` directory (along with the compiled classes).
