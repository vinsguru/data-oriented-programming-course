package com.vinsguru.sec05.domain;

public interface LoanProcessor {

    default LoanStatus process(LoanStatus loanStatus){
        return switch (loanStatus){
            case LoanStatus.Submitted submitted -> this.process(this.handle(submitted));
            case LoanStatus.Reviewed reviewed -> this.process(this.handle(reviewed));
            case LoanStatus.Approved approved -> approved;
            case LoanStatus.Denied denied -> denied;
        };
    }

    LoanStatus handle(LoanStatus.Submitted submitted);
    LoanStatus handle(LoanStatus.Reviewed reviewed);

}
