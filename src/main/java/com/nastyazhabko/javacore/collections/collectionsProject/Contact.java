package com.nastyazhabko.javacore.collections.collectionsProject;

public class Contact {
    private String name;
    private String phone;
    private String email;
    private String group;

    @Override
    public String toString(){
        return "Имя: " +name + "\nТелефон: " + phone + "\nE-mail: " + email + "\nГруппа: " + group;
    }

    @Override
    public int hashCode(){
        return name.hashCode() + phone.hashCode() + email.hashCode() + group.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        Contact other = (Contact) obj;
        if(!name.equals(other.name) || !phone.equals(other.phone) || !email.equals(other.email)) return false;
        return true;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
