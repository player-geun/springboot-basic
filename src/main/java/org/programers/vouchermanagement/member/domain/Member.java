package org.programers.vouchermanagement.member.domain;

import java.util.UUID;

public class Member {

    private final UUID id;

    private MemberStatus status;

    public Member(MemberStatus status) {
        this(UUID.randomUUID(), status);
    }

    public Member(UUID id, MemberStatus status) {
        this.id = id;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public MemberStatus getStatus() {
        return status;
    }
}
