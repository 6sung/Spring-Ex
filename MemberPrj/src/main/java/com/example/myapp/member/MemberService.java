package com.example.myapp.member;

public class MemberService implements IMemberService {

    @Override
    public Member getMemberInfo() {
        Member member = new Member();
        member.setMemberId("1234");
        member.setName("hong");
        member.setAge(20);
        member.setEmail("sdfasdfa@asasf");
        return member;
    }
}
