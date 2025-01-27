package problems.CourseScheduleIV

import utils.printArray

// https://leetcode.com/problems/course-schedule-iv/

private class Solution {
    // Time: O(V^3 + E + Q), where V is the number of courses, E is
    // the number of edges, and Q is the number of queries.
    // Space: O(V^2), because we use a 2D matrix.
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        // 2D matrix that stores if a course is a prerequisite of another.
        val isPrereq = Array(numCourses) { BooleanArray(numCourses) }

        // Add the direct prerequisites.
        for ((prereq, crs) in prerequisites) { // O(E)
            isPrereq[crs][prereq] = true
        }

        // Loop over all the courses and their prerequisites to get the indirect ones.
        for (k in 0..<numCourses) { // O(V)
            for (i in 0..<numCourses) { // O(V)
                for (j in 0..<numCourses) { // O(V)
                    // If course 3 is a prerequisite for course 2, and course 2 is a prerequisite
                    // for course 1, then course 3 is an indirect prerequisite for course 1.
                    if (isPrereq[j][k] && isPrereq[k][i]) {
                        isPrereq[i][j] = true
                    }
                }
            }
        }

        // Build the result array using the 2D matrix of prerequisites.
        val res = mutableListOf<Boolean>()
        for ((u, v) in queries) { // O(Q)
            res.add(isPrereq[u][v])
        }

        return res
    }

    // Time: O(E + V + E + Q), where V is the number of courses, E is
    // the number of edges, and Q is the number of queries.
    // Space: O(V^2 + E + Q), because the map stores a Set for each node.
    /*fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        // Build the adjacency list, where the index is the course and
        // the value is a list of its direct prerequisites.
        val adj = Array(numCourses) { mutableListOf<Int>() }
        for ((prereq, crs) in prerequisites) { // O(E)
            adj[crs].add(prereq)
        }

        // Store a set of all prerequisites (direct and indirect) for each course.
        val prereqMap = mutableMapOf<Int, MutableSet<Int>>()

        // Use DFS to traverse the courses.
        fun dfs(crs: Int): Set<Int> { // O(V + E)
            // The course is not visited before.
            if (prereqMap[crs] == null) {
                // Initialize its prerequisites set with itself because it will
                // be a prerequisite for its parent.
                prereqMap[crs] = mutableSetOf(crs)

                // Add all the prerequisites of its neighbors.
                for (nei in adj[crs]) {
                    prereqMap[crs]!!.addAll(dfs(nei))
                }
            }

            // Return the prerequisites for the parent.
            return prereqMap[crs]!!
        }

        // Compute the prerequisites for all the courses.
        for (i in 0..<numCourses) { // O(V)
            dfs(i)
        }

        // Build the result array using the precomputed sets.
        val res = mutableListOf<Boolean>()
        for ((u, v) in queries) { // O(Q)
            res.add(u in prereqMap[v]!!)
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()

    printArray(
        sol.checkIfPrerequisite(
            numCourses = 2,
            prerequisites = arrayOf(
                intArrayOf(1, 0)
            ),
            queries = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 0)
            )
        )
    )

    printArray(
        sol.checkIfPrerequisite(
            numCourses = 2,
            prerequisites = arrayOf(),
            queries = arrayOf(
                intArrayOf(1, 0),
                intArrayOf(0, 1)
            )
        )
    )

    printArray(
        sol.checkIfPrerequisite(
            numCourses = 3,
            prerequisites = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 0),
                intArrayOf(2, 0)
            ),
            queries = arrayOf(
                intArrayOf(1, 0),
                intArrayOf(1, 2)
            )
        )
    )
}