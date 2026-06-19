package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public class hwfirst {

    public DcMotor rf;
    public DcMotor lf;
    public DcMotor rb;
    public DcMotor lb;
    public static double maxSpeed = 0.5;

    // creating instance of hw class
    private static hwfirst myInstance = null;
    public static hwfirst getInstance() {
        if (myInstance == null) {
            myInstance = new hwfirst();
        }
        return myInstance;
    }

    public void init(HardwareMap hwMap) {
        //port 1 on controller motor hub cm1= control hub motor 1
        //em1 expansion hub, motor, port 1
        //cs0 control hub servo port 0
        //es5 = ext hub servo on port 5

        rf = hwMap.get(DcMotor.class, "cm1");
        rb = hwMap.get(DcMotor.class, "cm2");
        lf = hwMap.get(DcMotor.class, "cm3");
        lb = hwMap.get(DcMotor.class, "cm0");

        //set zero power behavior to BRAKE
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //setting motor running mode
        rf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //set initial power to 0
        rf.setPower(0);
        rb.setPower(0);
        lf.setPower(0);
        lb.setPower(0);


    }
    // setting power for the motors in ranges min to max
    public  void setPower(double fr, double br, double fl, double bl) {
        rf.setPower(Range.clip (fr, -maxSpeed, maxSpeed));
        rb.setPower(Range.clip (rf, -maxSpeed, maxSpeed));
        lf.setPower(Range.clip (rf, -maxSpeed, maxSpeed));
        lb.setPower(Range.clip (rf, -maxSpeed, maxSpeed));

    }

}
