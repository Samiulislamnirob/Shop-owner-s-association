package com.example.demo3;

public class Registration {
    private String memberId;
    private String memberName;
    private String program;

    public Registration(String memberId, String memberName, String program) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.program = program;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getProgram() {
        return program;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
