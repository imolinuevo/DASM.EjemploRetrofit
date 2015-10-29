package es.upm.miw.demoretrofit.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Group {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("groupname")
    @Expose
    private String groupname;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The groupname
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     *
     * @param groupname
     * The groupname
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupname='" + groupname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }

    public static Group parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        Group grupo = gson.fromJson(response, Group.class);

        return grupo;
    }

}