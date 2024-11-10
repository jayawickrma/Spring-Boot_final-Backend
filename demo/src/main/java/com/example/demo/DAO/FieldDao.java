package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDao extends JpaRepository<FieldEntity,String> {


//fieldCode    let fieldIds = [];
//
//    $('#additionalField select').each(function () {
//        // fieldIds.push($(this).val()); // Collect each additional select value
//        let ids = $(this).val();
//        const fields = {
//                fieldCode:ids
//        }
//        fieldIds.push(fields);
//    });
//
//    fieldIds = fieldIds.filter(id => ({ fieldCode: id }));
//
//    formData.append("fieldList", new Blob([JSON.stringify(fieldIds)], { type: "application/json" }));
}
