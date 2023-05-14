package com.tahauddin.syed.configuration.batch.step.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class CustomerStepListener implements StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Step Name  :: {}", stepExecution.getStepName());
        log.info("Before Executing Step Local Date Time :: {}", LocalDateTime.now());
        log.info("Step Start Time  :: {}", stepExecution.getStartTime());
        log.info("Step End Time  :: {}", stepExecution.getEndTime());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {

        log.info("After Step Status :: {}", stepExecution.getStatus());
        log.info("After Step Exit Status :: {}", stepExecution.getExitStatus());

        log.info("Commit Count  :: {}", stepExecution.getCommitCount());
        log.info("Step Read Count  :: {}", stepExecution.getReadCount());
        log.info("Step Roll Back Count  :: {}", stepExecution.getRollbackCount());
        log.info("Step Filter Count  :: {}", stepExecution.getFilterCount());

        if(stepExecution.getExitStatus().equals("UNKNOWN")){
            return ExitStatus.UNKNOWN;
        } else if(stepExecution.getExitStatus().equals("COMPLETED")) {
            return ExitStatus.COMPLETED;
        } else if(stepExecution.getExitStatus().equals("NOOP")) {
            return ExitStatus.NOOP;
        } else if(stepExecution.getExitStatus().equals("FAILED")) {
            return ExitStatus.FAILED;
        } else if(stepExecution.getExitStatus().equals("STOPPED")) {
            return ExitStatus.STOPPED;
        } else {
            return ExitStatus.EXECUTING;
        }
    }
}
