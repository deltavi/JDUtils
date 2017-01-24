package com.vincenzodevivo.jdutils.regex.dsl;

import com.vincenzodevivo.jdutils.string.StringUtils;

import java.util.List;

/**
 * Created by Vincenzo De Vivo on 21/01/2017.
 */
public class GroupExpression extends Expression {
    private String name;
    private List<Expression> expressions;

    public GroupExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public GroupExpression(List<Expression> expressions, String groupName) {
        this.expressions = expressions;
        this.name = groupName;
    }

    @Override
    public String toString() {
        StringBuilder exp = new StringBuilder();
        exp.append("(");
        if (!StringUtils.isEmpty(name)) {
            exp.append("?<");
            exp.append(name);
            exp.append(">");
        }
        for (Expression expression : expressions) {
            exp.append(expression.toString());
        }
        exp.append(")");
        return exp.toString();
    }
}
