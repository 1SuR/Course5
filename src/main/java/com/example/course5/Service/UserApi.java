package com.example.course5.Service;


import com.example.course5.Dao.IuserDao;
import com.example.course5.Entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/api/User")
public class UserApi {
    @Autowired
    private IuserDao userDao;

    @GetMapping("/login/{id}/{password}")
    @ApiOperation("用户登录的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", defaultValue = "admin", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "123456", required = true)
    })
    public String login(@PathVariable String id, @PathVariable String password) {
        User u = userDao.findUserByIdAndPassword(id, password);
        if (u == null) {
            return "Please Login in first!";
        }
        return "Welcome" + u.getName() + "!";
    }

    @PostMapping("/login")
    @ApiOperation("用户登录的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", defaultValue = "admin", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "123456", required = true)
    })
    public String loginByIdAndPassword(@RequestParam String id, @RequestParam String password) {
        User u = userDao.findUserByIdAndPassword(id, password);
        if (u == null) {
            return "Please Login in first!";
        }
        return "Welcome" + u.getName() + "!";
    }

    @PostMapping("/register")
    @ApiOperation("用户注册的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", defaultValue = "admin", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "123456", required = true)
    })
    public String registerUser(@RequestParam String id, @RequestParam String name, @RequestParam String password, @RequestParam int age, @RequestParam boolean sex) {
        if (id == null) {
            return "Please complete the id";
        }
        User u = new User();
        u.setId(id);
        u.setName(name);
        u.setPassword(password);
        u.setSex(sex);
        u.setAge(age);
        try {
            userDao.save(u);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "创建成功";
    }

    @PostMapping("/register2")
    @ApiOperation("用户注册的接口2")
    @ApiImplicitParam(name = "user", value = "用户JSION数据", defaultValue = "123456", required = true)
    public String registerUser2(@RequestBody User user) {

        try {
            userDao.save(user);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "创建成功";
    }

    @PutMapping("Update")
    public String Update(@RequestBody User user) {

        try {
            userDao.save(user);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "修改成功";
    }

    @DeleteMapping("/delete")
    public String DeleteUser(@RequestParam String id) {
        userDao.deleteById(id);
        return "删除成功";
    }
}
