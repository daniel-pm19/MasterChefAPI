package com.dosw.MasterChefAPI.model.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ParticipantRole {
    CONTESTANT,
    JUDGE,
    VIEWER
}
