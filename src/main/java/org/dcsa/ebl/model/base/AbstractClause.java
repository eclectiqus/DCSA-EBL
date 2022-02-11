package org.dcsa.ebl.model.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.dcsa.core.model.AuditBase;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class AbstractClause extends AuditBase {
    @Id
    private UUID id;

    @Column("clause_content")
    private String clauseContent;
}
