package com.amazon.ata.dynamodbdeleteiterators.classroom.activity;

import com.amazon.ata.dynamodbdeleteiterators.classroom.dao.MemberDao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class DeleteMemberActivityTest {
    @InjectMocks
    private DeleteMemberActivity activity;

    @Mock
    private MemberDao memberDao;

    @BeforeEach
    private void setup() {
        initMocks(this);
    }

    @Test
    void handleRequest_attemptsToDeleteMember() {
        // GIVEN
        String memberId = "1234";

        // WHEN
        activity.handleRequest(memberId);

        // THEN
        verify(memberDao).deletePermanently(memberId);
    }
}
