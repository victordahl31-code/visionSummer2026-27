package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public class Hardware {

    // naming the DcMotors

    public DcMotor rf;

    public DcMotor lf;

    public DcMotor lb;

    public DcMotor rb;

    //create max speed variable
    public static double maxSpeed = 0.5;

    private static Hardware myInstance = null;
    public static Hardware getInstance()   {

        if (myInstance == null) {
            myInstance = new Hardware();
        }
        return myInstance;
    }

    public void init(HardwareMap hwMap) {

        rf = hwMap.get(DcMotor.class, "cm1");

        //cm1 = control hub, motor, port 1
        //em1 = expansion hub, motor, port 1
        //cs0 = control hub, servo, port 0
        //es5 = expansion hub, servo, port 5



        rf = hwMap.get(DcMotor.class, "cm1"); // naming the device
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // set power behavior to brake
        rf.setMode(DcMotor.RunMode.RUN_USING_ENCODER); // how to run
        rf.setPower(0); // setting the power

        lf = hwMap.get(DcMotor.class, "cm2"); // naming the device
        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // set power behavior to brake
        lf.setMode(DcMotor.RunMode.RUN_USING_ENCODER); // how to run
        lf.setPower(0); // setting the power

        rb = hwMap.get(DcMotor.class, "cm3"); // naming the device
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // set power behavior to brake
        rb.setMode(DcMotor.RunMode.RUN_USING_ENCODER); // how to run
        rb.setPower(0); // setting the power

        lb = hwMap.get(DcMotor.class, "cm0"); // naming the device
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // set power behavior to brake
        lb.setMode(DcMotor.RunMode.RUN_USING_ENCODER); // how to run
        lb.setPower(0); // setting the power
    }

        public void setPower(double fr, double bl, double fl, double br) {

        // setting power to maxSpeed

            rf.setPower(Range.clip(fr, -maxSpeed, maxSpeed));
            rb.setPower(Range.clip(br, -maxSpeed, maxSpeed));
            lf.setPower(Range.clip(fl, -maxSpeed, maxSpeed));
            lb.setPower(Range.clip(bl, -maxSpeed, maxSpeed));

        }



}
