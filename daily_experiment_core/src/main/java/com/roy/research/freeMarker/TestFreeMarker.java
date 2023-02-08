package com.roy.research.freeMarker;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * freemark文本替换
 *
 * FTL指令 https://blog.csdn.net/u014414110/article/details/86591314
 *
 * 1. assign指令
 * 2 include指令
 * 3 if指令
 *
 *
 * @author guojun
 * @date 2022/12/1 15:31
 */
@Slf4j
public class TestFreeMarker {

//    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestFreeMarker.class);

    static class Solution {
        public String parseFreeMark(String templateStr, Map<String, String> param) {
            StringTemplateLoader templateLoader = new StringTemplateLoader();
            String tplName = "tpl_1";

            templateLoader.putTemplate(tplName, templateStr);
            Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
            cfg.setTemplateLoader(templateLoader);
            Template template = null;
            try {
                template = cfg.getTemplate(tplName);
                StringWriter writer = new StringWriter();
                template.process(param, writer);
                return writer.toString() ;
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            } catch (TemplateException e) {
                log.error(e.getMessage(), e);
            }
            return null;
        }

        public static List<String> getVariableNames(String templateStr) {
            String pattern = "\\$\\{(.*?)\\}";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(templateStr);
            Set<String> result = new LinkedHashSet<>();
            while (m.find()) {
                result.add(m.group(1));
            }
            return new ArrayList<>(result);
        }

        public void main() {
            String tplStr = "\n" +
                    "<#if data_source??> and data_source = '${data_source}' <#else> </#if> ";

            getVariableNames(tplStr);

            String result = parseFreeMark(tplStr, new HashMap<String, String>() {
                {
                    put("data_source", "kkkk");
                }
            });
            log.debug("result: {}", result);
        }
    }


    public static void main(String[] args) {
        new Solution().main();
    }
}
