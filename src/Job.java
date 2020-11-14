import javax.sound.midi.Sequence;
import java.util.List;
import java.util.*;


 class Job {

     public long getEntryTime() {
         return entryTime;
     }

     public void setEntryTime(long entryTime) {
         this.entryTime = entryTime;
     }

     public long getEndTime() {
         return endTime;
     }

     public void setEndTime(long endTime) {
         this.endTime = endTime;
     }

     public long getWaitTime() {
         return waitTime;
     }

     public void setWaitTime(long waitTime) {
         this.waitTime = waitTime;
     }

     String jobName;
     int jobLength; // indicates how much time the job needs to be allocated the CPU before it is finally terminated, between 1 and 70
     int currentJobLength;
     int jobPriority;
     int finalPriority;
     long entryTime;
     long endTime;
     long waitTime;

     static int lowPriorityCounter;

     public Job() {
         this.jobName = null;
         this.jobLength = 0;
         this.currentJobLength = 0;
         this.jobPriority = 0;
         this.finalPriority = 0;
         this.entryTime = 0;
         this.endTime = 0;
         this.waitTime = 0;
     }


     public Job(String jobName, int jobLength, int currentJobLength, int jobPriority, int finalPriority, long entryTime, long endTime, long waitTime) {
         this.jobName = jobName;
         this.jobLength = jobLength;
         this.currentJobLength = currentJobLength;
         this.jobPriority = jobPriority;
         this.finalPriority = finalPriority;
         this.entryTime = entryTime;
         this.endTime = endTime;
         this.waitTime = waitTime;
     }

     public int getJobPriority() {
         return jobPriority;
     }

     public void setJobPriority(int jobPriority) {
         this.jobPriority = jobPriority;
     }

     @Override
     public String toString() {
         return "Job{" +
                 "jobName='" + jobName + '\'' +
                 ", jobLength=" + jobLength +
                 ", currentJobLength=" + currentJobLength +
                 ", jobPriority=" + jobPriority +
                 '}';
     }
 }


    class JobList {


        public Job[] JobL;
        int jobCount;

        public JobList(Job[] jobL) {
            JobL = jobL;
        }

        Job min() {

            int x = 0;
            Job selected = new Job();

            for (int i = 0; i < JobL.length; i++) {

                if (JobL[i].getJobPriority() < x) {
                    x = JobL[i].getJobPriority();
                    selected = JobL[i];
                }

            }
            return selected;
        }

        Job removeMin() {

            int x = 0;
            int toRemove = 0;
            Job selected = new Job();

            for (int i = 0; i < JobL.length; i++) {

                if (JobL[i].getJobPriority() < x) {
                    x = JobL[i].getJobPriority();
                    selected = JobL[i];
                    toRemove = i;

                }

            }
            System.out.println("Now executing " + JobL[toRemove].toString());
            JobL[toRemove] = null;
            return selected;
        }



         Job insert(Job job) {

             if (JobL[JobL.length] !=null){

                 JobL = new Job[JobL.length*2];
             }

             JobL[jobCount+1] = job;
             jobCount++;
             return job;
        }



        int size() {

            int i = 0;
            for (; i <JobL.length;i++) {
                i++;
            }
            return i;
        }


    }






