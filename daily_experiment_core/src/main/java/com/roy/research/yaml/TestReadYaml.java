package com.roy.research.yaml;

import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.BaseConstructor;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.reader.UnicodeReader;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.resolver.Resolver;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

/**
 * #1，YAML大小写敏感；
 * #2，使用缩进代表层级关系；
 * #3，缩进只能使用空格，不能使用TAB，不要求空格个数，只需要相同层级左对齐（一般2个或4个空格)
 */
public class TestReadYaml {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestReadYaml.class);
    private static final String PATH = "";

    public void testReadYaml() throws FileNotFoundException {
        BaseConstructor constructor = new Constructor();
        Representer representer = new Representer();
        DumperOptions dumperOptions = new DumperOptions();
        Resolver resolver = new Resolver();
        LoaderOptions loaderOptions = new LoaderOptions();
        loaderOptions.setAllowDuplicateKeys(false);
        Yaml yaml = new Yaml(constructor, representer, dumperOptions, loaderOptions, resolver);

//        FileInputStream inputStream = new FileInputStream();
        Reader reader = new UnicodeReader(TestReadYaml.class.getClassLoader().getResourceAsStream("com.roy.miscellaneous.yaml/application.yml"));
        Iterable<Object> objects = yaml.loadAll(reader);
        for (Object obj : objects) {
            int k=0;
            Map<String, Object> map = (Map<String, Object>) obj;
            List<String> serverList = (List<String>) ((Map) (map.get("my"))).get("servers");
            for (String s : serverList) {
                LOGGER.info("key:{},  value: {}", "server" ,s);
            }


        }


    }




}
