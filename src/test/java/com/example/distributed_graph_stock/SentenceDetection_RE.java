package com.example.distributed_graph_stock;

import opennlp.tools.langdetect.*;
import opennlp.tools.ml.perceptron.PerceptronTrainer;
import opennlp.tools.namefind.*;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.*;
import opennlp.tools.util.model.ModelUtil;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/5/1 20:21
 * @PACKAGE_NAME: com.example.distributed_graph_stock
 * @CLASS_NAME: SentenceDetection_RE
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public class SentenceDetection_RE {
    @Test
    public void test1() throws IOException {
        String sentence = "Hi. How are you? Welcome to Tutorialspoint. "
                + "We provide free tutorials on various technologies";

        InputStream InputStream = new FileInputStream("D:\\NLP\\OpenNlP_models\\en-sent.bin"); //将模型的路径以String格式传递给其构造函数
        SentenceModel model = new SentenceModel(InputStream);
        SentenceDetectorME detector = new SentenceDetectorME(model); //SentenceDetectorME类包含将原始文本分割成句子的方法。该类使用最大熵模型来评估字符string中的结尾字符，以确定它们是否表示句子的结尾。

//        1、
        String sentences[] = detector.sentDetect(sentence); //sentDetect（）方法用于检测传递给它的原始文本中的句子,将原始文本分割成句子的方法。此方法接受String变量作为参数。
        for (String sent : sentences)
            System.out.println(sent);

//        2、
        Span spans[] = detector.sentPosDetect(sentence); //方法用于检测传递给它的原始文本中句子的位置,此方法接受String变量作为参数。
        for (Span span : spans) {  //将sentPosDetect（）方法返回的跨度存储在Span数组中，并将其打印出来
            System.out.println(span);
        }
//        String类的substring（）方法接受开始和结束偏移并返回相应的字符string。我们可以使用这种方法将句子及其跨度（位置）打印在一起，getStart和getEnd知道开始和结束的索引
        for (Span span : spans)
            System.out.println(sentence.substring(span.getStart(), span.getEnd()) + " " + span);
//      3、
        double[] probs = detector.getSentenceProbabilities(); //getSentenceProbabilities（）方法返回与最近调用sentDetect（）方法相关联的概率
        for(int i = 0; i<probs.length; i++){
            System.out.println(probs[i]);
    }

//        String simple = "[.?!]";
//        String[] splitString = (sentence.split(simple));
//        for (String string : splitString)
//            System.out.println(string);

    }
    @Test
    public void test2() throws IOException {
        String sentence = "Hi. How are you? Welcome to Tutorialspoint. "
                + "We provide free tutorials on various technologies";

//        1、SimpleTokenizer
        //Instantiating SimpleTokenizer class
//        SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE; //此类使用字符类标记给定的原始文本。

        //Tokenizing the given sentence
//        String tokens[] = simpleTokenizer.tokenize(sentence); //使用tokenize（）方法令牌化。

        //Printing the tokens
//        for(String token : tokens) { //打印令牌。
//            System.out.println(token);
//        }
//        2、WhitespaceTokenizer


        //Instantiating whitespaceTokenizer class
//        WhitespaceTokenizer whitespaceTokenizer = WhitespaceTokenizer.INSTANCE;
//
//        //Tokenizing the given paragraph
//        String tokens[] = whitespaceTokenizer.tokenize(sentence);
//
//        //Printing the tokens
//        for(String token : tokens)
//            System.out.println(token);
//    }
//        3、TokenizerME
        //OpenNLP还使用预定义的模型，一个名为de-token.bin的文件来标记句子。它被训练为给定原始文本中的句子进行标记。
        //Loading the Tokenizer model
        InputStream inputStream = new FileInputStream("D:\\NLP\\OpenNlP_models\\en-token.bin");
        TokenizerModel tokenModel = new TokenizerModel(inputStream);

        //Instantiating the TokenizerME class
        TokenizerME tokenizer = new TokenizerME(tokenModel);

        //Tokenizing the given raw text
//        String tokens[] = tokenizer.tokenize(sentence);
        Span[] spans = tokenizer.tokenizePos(sentence); //获取跨度
//        for (Span span : spans) {
//            System.out.println(sentence.substring(span.getStart(),span.getEnd())+"  "+span);
//        }
        //Printing the tokens
//        for (String a : tokens)
//            System.out.println(a);
        //获取概率，getTokenProbabilities（）方法用于获取与最近对tokenizePos（）方法的调用相关联的概率。
        double[] probs = tokenizer.getTokenProbabilities();
//        for (double prob : probs) {
//            System.out.println(prob);
//        }

        for (int i = 0; i < spans.length; i++) {
            System.out.println(sentence.substring(spans[i].getStart(),spans[i].getEnd())+"  "+spans[i]+ " "+probs[i]);
        }
    }
    @Test
    public void test3() throws IOException {
        InputStream inputStream = new FileInputStream("D:\\NLP\\OpenNlP_models\\en-ner-person.bin"); //查找名字实体的模型
        TokenNameFinderModel model = new TokenNameFinderModel(inputStream);
        NameFinderME nameFinder = new NameFinderME(model);

        InputStream inputStreamTokenizer = new
                FileInputStream("D:\\NLP\\OpenNlP_models\\en-token.bin"); //分词模型
        TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);

        //Instantiating the TokenizerME class
        TokenizerME tokenizer = new TokenizerME(tokenModel);

        String sentence = "Mike is senior programming manager and Rama is a clerk both are working at Tutorialspoint,Tutorialspoint is located in 中国";

        String tokens[] = tokenizer.tokenize(sentence);
        //Finding the names in the sentence
        Span nameSpans[] = nameFinder.find(tokens);  //查找名字实体的方法
        double[] probs = nameFinder.probs();

        //Printing the spans of the names in the sentence
        for (int i = 0; i < nameSpans.length; i++) {
            System.out.println(tokens[nameSpans[i].getStart()]+"  "+nameSpans[i].toString()+" "+probs[i]);
        }

//        查找地名
//        InputStream inputStreamNameFinder = new
//                FileInputStream("D:\\NLP\\OpenNlP_models\\en-ner-location.bin");
//        TokenNameFinderModel model1 = new TokenNameFinderModel(inputStreamNameFinder);
//
//        NameFinderME nameFinder1 = new NameFinderME(model1);
//
//        Span nameSpans1[] = nameFinder1.find(tokens);
//        double[] probs1 = nameFinder1.probs();
//        for (int i = 0; i < nameSpans.length; i++) {
//            System.out.println(tokens[nameSpans1[i].getStart()]+"  "+nameSpans1[i].toString()+" "+probs1[i]);
//        }
    }
    @Test
    public void test4() throws IOException {
        InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(new File("D:\\NLP\\OpenNlP_models\\stock.txt"));

        ObjectStream<String> lineStream = new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8);
        ObjectStream<LanguageSample> sampleStream = new LanguageDetectorSampleStream(lineStream);

        TrainingParameters params = ModelUtil.createDefaultTrainingParameters();
        params.put(TrainingParameters.ALGORITHM_PARAM,
                PerceptronTrainer.PERCEPTRON_VALUE);
        params.put(TrainingParameters.CUTOFF_PARAM, 0);

        LanguageDetectorFactory factory = new LanguageDetectorFactory();

        LanguageDetectorModel model = LanguageDetectorME.train(sampleStream, params, factory);
        model.serialize(new File("D:\\NLP\\OpenNlP_models\\ch-langdetect1.bin"));
    }

    @Test
    public void test5(){
        try (InputStream modelIn = new FileInputStream("D:\\NLP\\OpenNlP_models\\ch-stock_cname.bin")) {
            LanguageDetectorModel m = new LanguageDetectorModel(modelIn);
            LanguageDetector languageDetectorME = new LanguageDetectorME(m);
            Language bestLanguage = languageDetectorME.predictLanguage("测试语言嗅探器");
            System.out.println("Best language: " + bestLanguage.getLang()); // 预测语言
            System.out.println("Best language confidence: " + bestLanguage.getConfidence()); // 语言置信度
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test6() throws IOException {
        String onlpModelPath = "D:\\NLP\\OpenNlP_models\\stock_cname.bin";
        // training data set
        InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(new File("D:\\NLP\\OpenNlP_models\\stock_cname.txt"));
        ObjectStream<String> lineStream = new PlainTextByLineStream(inputStreamFactory,"UTF-8");

        ObjectStream<NameSample> sampleStream = new NameSampleDataStream(lineStream);

        TokenNameFinderModel model = null;
        HashMap<String, Object> mp = new HashMap<String, Object>();
//                     model = NameFinderME.train("en","drugs", sampleStream, Collections.<String,Object>emptyMap(),100,4) ;
        model=  NameFinderME.train("ch", "cname", sampleStream,TrainingParameters.defaultParams(),new TokenNameFinderFactory());
        //sampleStream.close();

        BufferedOutputStream modelOut =  new BufferedOutputStream(new FileOutputStream(onlpModelPath));
            model.serialize(modelOut);
            if (modelOut != null)
                modelOut.close();
    }
    @Test
    public void test7() throws IOException {
        InputStream inputStream = new FileInputStream("D:\\NLP\\OpenNlP_models\\ch-stock_cname.bin"); //查找名字实体的模型
        TokenNameFinderModel model = new TokenNameFinderModel(inputStream);
        NameFinderME nameFinder = new NameFinderME(model);

        System.out.println(nameFinder);

        InputStream inputStreamTokenizer = new
                FileInputStream("D:\\NLP\\OpenNlP_models\\en-token.bin"); //分词模型
        TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);

        //Instantiating the TokenizerME class
        TokenizerME tokenizer = new TokenizerME(tokenModel);

        String sentence = "Julie is senior programming manager and Rama is a clerk both are working at Tutorialspoint";

        String tokens[] = tokenizer.tokenize(sentence);

        //Finding the names in the sentence
        Span nameSpans[] = nameFinder.find(tokens);  //查找名字实体的方法
        double[] probs = nameFinder.probs();
        for (int i = 0; i < nameSpans.length; i++) {
            System.out.println(tokens[nameSpans[i].getStart()]+"  "+nameSpans[i].toString()+" "+probs[i]);
        }
    }
}


