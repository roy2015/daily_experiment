package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by apple on 2019/10/23.
 *给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。

 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。

 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。

 示例 1:

 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 输出: 11
 解释:
 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 注意:

 一个员工最多有一个直系领导，但是可以有多个直系下属
 员工数量不超过2000。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/employee-importance
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution690 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution690.class);

    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    /**
     */
    static class Solution {

        /**
         *
         * 执行用时 :15 ms, 在所有 java 提交中击败了59.42%的用户
         内存消耗 :47.3 MB, 在所有 java 提交中击败了97.83%的用户
         * @param employees
         * @param id
         * @return
         */
        public int getImportance(List<Employee> employees, int id) {
            Employee employee = null;
            int index =0;

            for (int i = 0; i < employees.size(); i++) {
                Employee employee1 = employees.get(i);
                if (employee1.id == id) {
                    employee = employee1;
                    index = i;
                    break;
                }
            }

            List<Integer> subordinates = employee.subordinates;
            if (subordinates == null || subordinates.isEmpty()) {
                employees.remove(index);
                return employee.importance;
            } else {
                int sumImport = employee.importance;
                for (Integer subordinate : subordinates) {
                    sumImport += getImportance(employees, subordinate);
                }
                return sumImport;
            }
        }

        /**
         *
         * 持续优化， 分析发现上面的性能瓶颈在根据id查找员工， 优化：新增一个 (id,employess)的 map，查找回快很多的
         *
         * 执行用时 :7 ms, 在所有 java 提交中击败了98.62%的用户
         内存消耗 :47.2 MB, 在所有 java 提交中击败了98.26%的用户
         *
         * @param employees
         * @param id
         * @return
         */
        public int getImportance1(List<Employee> employees, int id) {
            for (int i = 0; i < employees.size(); i++) {
                Employee employee1 = employees.get(i);
                employeeMap.put(employee1.id, employee1);
            }
            return getImportanceSub1(id);
        }
        private static Map<Integer, Employee> employeeMap = new HashMap<>() ;

        private int getImportanceSub1(int id) {
            Employee employee = employeeMap.get(id);

            List<Integer> subordinates = employee.subordinates;
            if (subordinates == null || subordinates.isEmpty()) {
                return employee.importance;
            } else {
                int sumImport = employee.importance;
                for (Integer subordinate : subordinates) {
                    sumImport += getImportanceSub1(subordinate);
                }
                return sumImport;
            }
        }
    }

    public static void main(String[] args) {
//        [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
//        输出: 11
        Employee employee1 = new Employee();
        List<Integer> list1 = new ArrayList<>();
        employee1.id =1;
        employee1.importance = 5;
        list1.add(2);
        list1.add(3);
        employee1.subordinates = list1;

        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance =3;
        employee2.subordinates = Collections.emptyList();

        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.importance =3;
        employee3.subordinates = Collections.emptyList();

        List<Employee> lists = new ArrayList<>();
        lists.add(employee1);
        lists.add(employee2);
        lists.add(employee3);
        logger.info("{}", new Solution().getImportance1(lists, 1));
    }

}
