package com.book.utils;


import java.io.Writer;

import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.IContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafUtil {

    private static final TemplateEngine engine;
    static {
        engine = new TemplateEngine();
        ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
        r.setCharacterEncoding("UTF-8");
        engine.setTemplateResolver(r);
    }

    public static void process(String template, IContext context, Writer writer) {
        engine.process(template, context, writer);
    }
}