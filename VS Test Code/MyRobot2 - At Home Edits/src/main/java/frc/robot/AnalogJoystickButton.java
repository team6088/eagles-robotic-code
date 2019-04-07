package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

public class AnalogJoystickButton extends Button {

    GenericHID m_joystick;
    int m_axisNumber;
    private int angle;

    public AnalogJoystickButton(GenericHID joystick, int axisNum, int angle) {
        m_joystick = joystick;
        m_axisNumber = axisNum;
        this.angle = angle;
    }

    @Override
    public boolean get() {
        return m_joystick.getPOV() == angle;
    }


}