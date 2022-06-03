package com.javarush.task.task23.task2304;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Inner 3
*/

public class Solution {

    private List<Task> tasks = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = MockView.getFakeTaskCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = MockView.getFakeNameCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.refresh();
    }

    private class TaskDataProvider implements DbDataProvider<Task> {
        public void refreshAllData(Map criteria) {
            for (Solution.Task task : MockDB.getFakeTasks(criteria)) {
                tasks.add(task);
            }

        }
    }

    private class NameDataProvider implements DbDataProvider<String> {
        public void refreshAllData(Map criteria) {
            for (java.lang.String name : MockDB.getFakeNames(criteria)) {
                names.add(name);
            }
        }
    }
}






























