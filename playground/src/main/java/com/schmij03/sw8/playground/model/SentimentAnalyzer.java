package com.schmij03.sw8.playground.model;

import java.io.IOException;
import java.util.List;

import org.slf4j.LoggerFactory;

import ai.djl.Application;
import ai.djl.Device;
import ai.djl.MalformedModelException;
import ai.djl.inference.Predictor;
import ai.djl.modality.Classifications;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ModelNotFoundException;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.TranslateException;
import ai.djl.util.JsonSerializable;
import ch.qos.logback.classic.Logger;

public class SentimentAnalyzer {
   
    private static final Logger logger = (Logger) LoggerFactory.getLogger(SentimentAnalyzer.class);
    
    public SentimentAnalyzer() {}

    public static Classifications predict(String inputtext) throws MalformedModelException, ModelNotFoundException,IOException, TranslateException {
        logger.info("inputtext: {}", inputtext);
                
        Criteria<String, Classifications> criteria = Criteria.builder()
            .optApplication(Application.NLP.SENTIMENT_ANALYSIS)
            .setTypes(String.class, Classifications.class)
            // This model was traced on CPU and can only run on CPU
            .optDevice(Device.cpu())
            .optProgress(new ProgressBar())
            .build();
        
        try (ZooModel<String, Classifications> model = criteria.loadModel();
            Predictor<String, Classifications> predictor = model.newPredictor()) {
        return predictor.predict(inputtext);
    }
    }

}
