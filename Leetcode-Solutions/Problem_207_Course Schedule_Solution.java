class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {

		/*
		This problem can be solved by directly applying Kahn's Algorithm.
		We need to return if the we can finish all the courses, given the dependency among courses.
		
		Input:
			1. we are given the number of courses.
			2. dependency matrix signifying the dependency between the two courses.
			
		Output:
			We need to return true or false, if we can finish the courses or not.
	
		Following are the steps to reach the solution:
		
		1. First we will create the graph, this is essentially required to know 
		   for a particular course, how many and which course dependency we have.
		 
		2. We will require one dependency array, where dependency[i] specifies total number of 
		   course we need to finish before taking the ith course.
		  		   
		3. We created one queue to add all the course for which there is no dependecy i.e dependecy[i] = 0 for ith course.
		   These will be the course which we will finish first.
		   we basically will start from these course for which we have no dependency and keep 
		   on adding the courses in the queue for which dependency becomes zero after finishing the course.
		   for ith course, we will decrease the value of dependecy array by 1 for all the course 
		   for which ith course was required first to be finished.
		 
		4. for every course we remove from queue, we increase the total count of courses we can finish.
		   Every deque will tell us that the particular course can be taken.
		   
		4. Once we are done with all the courses in the queue, we check the count of courses we have taken.
		   if the count equals total number of courses, we return true, else we return false.
		   
		   Time Complexity : O(V+E) 
		   Space Complexity: O(V)
		
		*/
        ArrayList<ArrayList<Integer>> graph  = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = null;
        int[] dependency = new int[numCourses];
        for(int i = 0; i < numCourses; i++ ) {
            dependency[i] = 0;
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0 ; i < pre.length; i++ ){
            dependency[pre[i][0]] += 1;
            graph.get(pre[i][1]).add(pre[i][0]);
        }
        Queue<Integer> q1 = new LinkedList<Integer>();
        for(int i =0; i < dependency.length; i++ ) {
            if( dependency[i] == 0 )  q1.add(i);
        }
        int index = 0;
        while( !q1.isEmpty()  ) {
            int course = q1.remove();
            index+=1;
            int totalNeighbours = graph.get(course).size();
            for(int i = 0; i < totalNeighbours; i++) {
                    int neighbour = graph.get(course).get(i);
                    dependency[neighbour] -= 1;
                    if( dependency[neighbour] == 0 ) q1.add(neighbour);
            }
        }
        if( index == numCourses ) return true;
        return false;
    }
}