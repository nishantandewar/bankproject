package com.nishant.bankproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmaiDetails {
        private String receipent;
        private String messagebody;
        private String subject;
        private String attachment;
}
