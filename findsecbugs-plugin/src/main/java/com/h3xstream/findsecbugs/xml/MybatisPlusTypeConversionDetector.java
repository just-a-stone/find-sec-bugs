/**
 * Find Security Bugs
 * Copyright (c) Philippe Arteau, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */
package com.h3xstream.findsecbugs.xml;

import com.h3xstream.findsecbugs.common.matcher.InvokeMatcherBuilder;
import edu.umd.cs.findbugs.*;
import edu.umd.cs.findbugs.ba.ClassContext;
import edu.umd.cs.findbugs.bcel.OpcodeStackDetector;
import org.apache.bcel.Const;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.LocalVariable;
import org.apache.bcel.classfile.Method;

import static com.h3xstream.findsecbugs.common.matcher.InstructionDSL.invokeInstruction;

public class MybatisPlusTypeConversionDetector extends OpcodeStackDetector {


    private static final String MYBATIS_DECODER = "MYBATIS_DECODER";
    private static final InvokeMatcherBuilder MYBATIS_DECODER_METHOD = invokeInstruction().atClass("com/baomidou/mybatisplus/core/conditions/query/LambdaQueryWrapper").atMethod("eq");

    private BugReporter bugReporter;

    public MybatisPlusTypeConversionDetector(BugReporter bugReporter) {
        this.bugReporter = bugReporter;
    }


    @Override
    public void sawOpcode(int seen) {
        if (seen == Const.INVOKEVIRTUAL && MYBATIS_DECODER_METHOD.matches(this)){
            OpcodeStack.Item item = stack.getStackItem(0);
            System.out.println(item);
        }
    }
}
