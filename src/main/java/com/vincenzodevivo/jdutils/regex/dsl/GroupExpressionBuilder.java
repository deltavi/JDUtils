package com.vincenzodevivo.jdutils.regex.dsl;

import java.util.Set;

/**
 * Created by Vincenzo De Vivo on 21/01/2017.
 */
public class GroupExpressionBuilder extends ExpressionBuilder {
    private final GroupExpression groupExpression;
    private final ExpressionBuilder parent;

    public GroupExpressionBuilder(ExpressionBuilder parent, Set<String> groupNames, String groupName) {
        super(groupNames);
        this.parent = parent;
        this.groupExpression = new GroupExpression(this.getSubExpressions(), groupName);
    }

    public GroupExpressionBuilder(ExpressionBuilder parent, Set<String> groupNames) {
        super(groupNames);
        this.parent = parent;
        this.groupExpression = new GroupExpression(this.getSubExpressions());
    }

    public ExpressionBuilder endGroup() {
        return parent;
    }

    public GroupExpression getGroup() {
        return groupExpression;
    }
}
