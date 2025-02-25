/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class App {
    public record Student (String name, String grade, List<String> badges) {}

    public final List<Student> students = List.of(
        new Student("Condiment King", "K", List.of("Chemistry", "Electronics")),
        new Student("Polka Dot Man", "4", List.of("Biology", "Chemistry")),
        new Student("Kite-Man", "7", List.of())
    );

    // this is an approximation of GET /v1/students
    public void getStudents() {
        for (final Student student : students) {
            System.out.println(
                new JSONObject()
                    .put("name", student.name())
                    .put("grade", student.grade)
                    .put("badges", new JSONArray().putAll(student.badges))
            );
        }
    }

    // this is an approximation of GET /v1/badgeSummary
    public void getBadgeSummary() {
        final Map<String, Integer> badgeCountByName = new HashMap<String, Integer>();

        for (final Student student : students) {
            for (final String badge : student.badges) {
                if (badgeCountByName.containsKey(badge)) {
                    badgeCountByName.put(badge, badgeCountByName.get(badge) + 1);

                } else {
                    badgeCountByName.put(badge, 1);
                }
            }
        }

        badgeCountByName.forEach((badge, count) ->
            System.out.println(
                new JSONObject().put(badge, count)
            )
        );
    }

    public static void main(String[] args) {
        new App().getStudents();
        new App().getBadgeSummary();
    }
}

