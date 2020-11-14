import java.util.Random;
import java.time.chrono.*;
public class PriorityQueueSimulatorTester {


    public static void main(String[] args){

        Random r1 = new Random();

        // we pick one of the five values

        int maxNumberOfJobs = 100;
//      int maxNumberOfJobs = 1000;
//      int maxNumberOfJobs = 10000;
//      int maxNumberOfJobs = 100000;
//      int maxNumberOfJobs = 1000000;

        Job[] jobsInputArray = new Job[maxNumberOfJobs];

        for (int i = 0; i < maxNumberOfJobs; i++) {

            String number = String.valueOf(i+1);
            int jLength = r1.nextInt(70)+1;
            int jPriority = r1.nextInt(40)+1;
            int finalPriority = jPriority;

            jobsInputArray[i] = new Job(("JOB_"+ number), jLength, jLength, jPriority, finalPriority, 0, 0, 0 );

        }

        JobList JList = new JobList(jobsInputArray);




    }

}
