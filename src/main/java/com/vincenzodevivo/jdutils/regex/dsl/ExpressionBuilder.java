package com.vincenzodevivo.jdutils.regex.dsl;

import com.vincenzodevivo.jdutils.regex.RegexConst;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.vincenzodevivo.jdutils.EmptyUtils.isEmpty;

/**
 * Created by Vincenzo De Vivo on 21/01/2017.
 */
public class ExpressionBuilder implements RegexConst {
    private List<Expression> subExpressions;
    private Set<String> groupNames;

    public ExpressionBuilder() {
        this.subExpressions = new ArrayList<>();
        this.groupNames = new HashSet<>();
    }

    public ExpressionBuilder(Set<String> groupNames) {
        this.subExpressions = new ArrayList<>();
        this.groupNames = groupNames;
    }

    public List<Expression> getSubExpressions() {
        return subExpressions;
    }

    public ExpressionBuilder letter() {
        subExpressions.add(new Expression(LETTER));
        return this;
    }

    public ExpressionBuilder email() {
        subExpressions.add(new Expression(EMAIL));
        return this;
    }

    public ExpressionBuilder integer() {
        subExpressions.add(new Expression(INTEGER));
        return this;
    }

    public ExpressionBuilder digit() {
        subExpressions.add(new Expression(DIGIT));
        return this;
    }

    public ExpressionBuilder digits() {
        subExpressions.add(new Expression(DIGITS));
        return this;
    }

    public ExpressionBuilder number() {
        subExpressions.add(new Expression(NUMBER));
        return this;
    }

    public ExpressionBuilder or() {
        subExpressions.add(new Expression(OR));
        return this;
    }

    public ExpressionBuilder s() {
        subExpressions.add(new Expression(OCC_ONE_OR_MORE));
        return this;
    }

    public ExpressionBuilder s(int min) {
        subExpressions.add(new Expression("{" + min + ",}"));
        return this;
    }

    public ExpressionBuilder s(int min, int max) {
        subExpressions.add(new Expression("{" + min + "," + max + "}"));
        return this;
    }

    public ExpressionBuilder exactOcc(int num) {
        subExpressions.add(new Expression("{" + num + "}"));
        return this;
    }

    public ExpressionBuilder start() {
        subExpressions.add(new Expression(START));
        return this;
    }

    public ExpressionBuilder any() {
        subExpressions.add(new Expression(ANY));
        return this;
    }

    public ExpressionBuilder end() {
        subExpressions.add(new Expression(END));
        return this;
    }

    public ExpressionBuilder value(String value) {
        subExpressions.add(new Expression(value));
        return this;
    }

    public ExpressionBuilder space() {
        subExpressions.add(new Expression(" "));
        return this;
    }

    public ExpressionBuilder constant(String value) {
        subExpressions.add(new Expression(Pattern.quote(value)));
        return this;
    }


    public GroupExpressionBuilder group() {
        GroupExpressionBuilder groupExpressionBuilder = new GroupExpressionBuilder(this, groupNames);
        subExpressions.add(groupExpressionBuilder.getGroup());
        return groupExpressionBuilder;
    }

    public GroupExpressionBuilder group(String name) throws GroupNameAlreadyDefinedException {
        if (!isEmpty(name)) {
            if (groupNames.contains(name)) {
                throw new GroupNameAlreadyDefinedException("Named group <" + name + "> is already defined!");
            } else {
                groupNames.add(name);
            }
        }
        GroupExpressionBuilder groupExpressionBuilder = new GroupExpressionBuilder(this, groupNames, name);
        subExpressions.add(groupExpressionBuilder.getGroup());
        return groupExpressionBuilder;
    }

    public ExpressionBuilder endGroup() {
        throw new RuntimeException("Cannot call end(), no opening group found!");
    }

    public Pattern toPattern() {
        return Pattern.compile(toString());
    }

    public Matcher toMatcher(CharSequence input) {
        return toPattern().matcher(input);
    }

    public List<String> findAll(String input) {
        List<String> list = new ArrayList<>();
        Matcher matcher = toMatcher(input);
        while (matcher.find()) {
            String group = matcher.group();
            if (!isEmpty(group)) {
                list.add(group);
            }
        }
        return list;
    }

    public List<Map<String, String>> findAllNamedGroup(String input) {
        List<Map<String, String>> list = new ArrayList<>();
        Matcher matcher = toMatcher(input);
        while (matcher.find()) {
            Map<String, String> groups = new HashMap<>();
            list.add(groups);
            for (String groupName : groupNames) {
                String group = matcher.group(groupName);
                if (!isEmpty(group)) {
                    groups.put(groupName, group);
                }
            }
        }
        return list;
    }

    public Map<String, String> findMap(String input, String keyName, String valueName) {
        Map<String, String> map = new HashMap<>();
        Matcher matcher = toMatcher(input);
        while (matcher.find()) {
                String key = matcher.group(keyName);
                if (!isEmpty(key)) {
                    map.put(key, matcher.group(valueName));
                }
        }
        return map;
    }

    public List<String> findAll(String input, String groupName) {
        List<String> list = new ArrayList<>();
        Matcher matcher = toMatcher(input);
        while (matcher.find()) {
            String group = matcher.group(groupName);
            if (!isEmpty(group)) {
                list.add(group);
            }
        }
        return list;
    }

    public String findFirst(String input) {
        Matcher matcher = toMatcher(input);
        while (matcher.find()) {
            String group = matcher.group();
            if (!isEmpty(group)) {
                return group;
            }
        }
        return null;
    }

    public String findFirst(String input, String groupName) {
        Matcher matcher = toMatcher(input);
        while (matcher.find()) {
            String group = matcher.group(groupName);
            if (!isEmpty(group)) {
                return group;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder exp = new StringBuilder();
        for (Expression expression : subExpressions) {
            exp.append(expression.toString());
        }
        return exp.toString();
    }
}
