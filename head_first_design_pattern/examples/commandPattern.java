// THE INVOKER
class RemoteControl { 
  Command[] onCommands;
  Command[] offCommands;

  Command undoCommand;

  public RemoteControl() {
    onCommands = new Command[7] // 7 slot of buttons
    offCommands = new Command[7] // 7 slot of buttons
    Command noCommand = new NoCommand() // default command for empty slots
    for (in i = 0; i < 7; i ++) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }
    undoCommand = noCommand;
  }
  public setCommand(int slot, Command onCommand, Command offCommand) {
      onCommands[i] = onCommand;
      offCommands[i] = offCommand;
  }

  public void onButtonWasPushed(int slot) {
    onCommands[slot].execute();
    undoCommand = onCommands[slot];
  }

  public void offButtonWasPushed(int slot) {
    offCommands[slot].execute();
    undoCommand = offCommands[slot];
  }

  public void undoButtonWasPushed() {
    undoCommand.undo();
  }
}

interface Command {
  void execute();
  void undo();
}

class NoCommand implements Command {
  public void execute() {
    // do nothing
  }

}

// RECEIVER
class Light {
  /* 
   * this could also be an interface for mulitple light sources such as garage light,
   * bed room light,... but we'll leave this for simplicity
  */
  public void on() {}
  public void off() {}
}

// RECEIVER
class GarageDoor {
  public void up(float percentage) {}
  public void down(float percentage) {}
  public void stop() {}
  public void lightOn() {}
  public void lightOff() {}
}

// CONCRETE COMMAND
// example for a button to turn the light on
public class LightOnCommand implements Command {
  Light light; // the receiver
 
  public LightOnCommand(Light light) {
    this.light = light;
  }

  public void execute() {
    this.light.on();
  }

  public void undo() {
    this.light.off();
  }
}

// CONCRETE COMMAND
// example to open the garage door
public class OpenGarageDoorCommand implements Command {
  GarageDoor garageDoor;
  float percentage;  // how many percent u want to door to go up

  public OpenGarageDoorCommand(GarageDoor door, percentage) {
    this.garageDoor = door;
    this.percentage = percentage;
  }

  public void execute() {
    this.garageDoor.up(this.percentage);
  }
  public void undo() {
    this.garageDoor.down(this.percentage);
  }
}

public class RemoteLoader {
  public static void main(String[] args) {
    Remote remote = new RemoteControl();
    
    Light bedRoomLight = new Light(); 
    GarageDoor door = new GarageDoor(); 

    Command slot1 = new LightOnCommand(bedRoomLight);
    // every click open 0.5% of the garage door for example.
    Command slot2 = new OpenGarageDoorCommand(door, 0.5);

    remote.setCommand(0, slot1);
    remote.setCommand(1, slot2);

    // user interact with the controller:
    remote.onButtonWasPushed(0);
    remote.undoButtonWasPushed();
  }
}
