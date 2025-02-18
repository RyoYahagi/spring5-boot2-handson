package com.example.web.form;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.persistence.entity.Customer;

public class CustomerForm {

    // TODO 3-01 検証アノテーションを付加する（空白不可、長さ1から32まで）
	@NotBlank
	@Length(min = 1, max = 32)
    private String firstName;

    // TODO 3-02 検証アノテーションを確認する（変更不要）
    @NotBlank
    @Length(min = 1, max = 32)
    private String lastName;

    @NotBlank
    @Length(min = 1, max = 128)
    @Email
    private String email;

    @NotNull
    // TODO 3-03 アノテーションで日付フォーマットを「uuuu-MM-dd」に指定する
    @DateTimeFormat(pattern = "uuuu-mm-dd")
    private LocalDate birthday;

    public CustomerForm(String firstName,
                        String lastName,
                        String email,
                        LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }

    /**
     * フィールドがすべて空（null）のCustomerFormインスタンスを生成するメソッド
     */
    public static CustomerForm createEmptyForm() {
        return new CustomerForm(null, null, null, null);
    }

    /**
     * エンティティのCustomerに変換するメソッド
     */
    public Customer convertToEntity() {
        return new Customer(firstName, lastName, email, birthday);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
