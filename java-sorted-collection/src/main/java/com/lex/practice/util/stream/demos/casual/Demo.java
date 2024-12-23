package com.lex.practice.util.stream.demos.casual;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        Map<String, Member> memberMap = new HashMap<>();
        memberMap.put("K001", new Member("K001", "John"));
        memberMap.put("K002", new Member("K002", ""));  // 空名稱
        memberMap.put("K003", new Member("K003", null));  // null 名稱

        AuthServer authServer = new AuthServer();
        authServer.addUser(new AuthUser("123", "Alice"));
        authServer.addUser(new AuthUser("456", "Bob"));

        UserNameResolver resolver = new UserNameResolver(memberMap, authServer);

        String[] testIds = {"K001", "K002", "K003", "K004", "123", "456", "789"};

        for (String id : testIds) {
            String resolvedName = resolver.resolveUserName(id);
            System.out.printf("ID: %-4s -> Resolved Name: %s%n", id, resolvedName);
        }
    }
}


class UserNameResolver {
    private final Map<String, Member> memberMap;
    private final AuthServer authServer;

    public UserNameResolver(Map<String, Member> memberMap, AuthServer authServer) {
        this.memberMap = memberMap;
        this.authServer = authServer;
    }

    public String resolveUserName(String userId) {
        if (userId == null) return "";

        return userId.toUpperCase().startsWith("K")
                ? Optional.ofNullable(getMember(userId))
                .map(Member::getMemberName)
                .filter(name -> !name.isEmpty())
                .orElse(userId)
                : Optional.of(userId)
                .map(Integer::parseInt)
                .map(authServer::getUser)
                .map(AuthUser::getAcctName)
                .filter(name -> !name.isEmpty())
                .orElse(userId);
    }

    private Member getMember(String userId) {
        return memberMap.get(userId);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Member {
    private String memberId;
    private String memberName;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class AuthUser {
    private String userId;
    private String acctName;
}

@Data
@NoArgsConstructor
class AuthServer {
    private final Map<String, AuthUser> userMap = new HashMap<>();

    public void addUser(AuthUser user) {
        userMap.put(user.getUserId(), user);
    }

    public AuthUser getUser(int userId) {
        return userMap.get(String.valueOf(userId));
    }
}