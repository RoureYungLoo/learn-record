module com.randolflu.helloworld {
    requires javafx.controls;
    requires javafx.graphics;

    opens com.randolflu.helloworld to javafx.graphics; // 如果有包需要打开
}