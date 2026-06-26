package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name = "jarvis")
public class Jarvis extends LinearOpMode {
    Hardware robot = Hardware.getInstance();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        telemetry.addData("Status", "hello, Drivers!");
        telemetry.update();

        waitForStart();
        move(67,0.67);
        move(32,0.3);
        move(24,0.80);
        turning( 800, 0.5);
    }
    public void move(double distance, double speed) {
        double wheelCircumference = 4 * Math.PI;
        double ticksPerRevolution = 537.7;
         double ticks = (distance * (ticksPerRevolution/wheelCircumference));
         // converting ticks to inches

         // resetting encoders so that previosly storewd values are deleted
        robot.rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.rf.setTargetPosition((int)Math.round(ticks));
        robot.lf.setTargetPosition((int)Math.round(ticks));
        robot.rb.setTargetPosition((int)Math.round(ticks));
        robot.lb.setTargetPosition((int)Math.round(ticks));

        robot.rf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.lf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.lb.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.setPower(speed, speed, speed, speed);

        while (opModeIsActive() && robot.rf.isBusy()) {


        }

        robot.setPower(0,0,0,0);

        robot.rf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.lf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.lb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }

    public void turning(int ticks, double speed) {

        robot.rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.rf.setTargetPosition(-ticks);
        robot.lf.setTargetPosition(ticks);
        robot.rb.setTargetPosition(-ticks);
        robot.lb.setTargetPosition(ticks);

        robot.rf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.lf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.lb.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.setPower(-speed, -speed, speed, speed);

        while (opModeIsActive() && robot.rf.isBusy()) {

        }

        robot.setPower(0,0,0,0);

        robot.rf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.lf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.lb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
}
