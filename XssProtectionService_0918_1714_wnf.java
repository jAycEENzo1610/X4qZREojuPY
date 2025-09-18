// 代码生成时间: 2025-09-18 17:14:08
package com.example.xssprotection;

import javax.enterprise.context.ApplicationScoped;
# 改进用户体验
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
# 改进用户体验
import java.util.regex.Matcher;

@ApplicationScoped
public class XssProtectionService {

    private static final Pattern[] patterns = new Pattern[] {
        // Matches JavaScript event handler attributes
        Pattern.compile("on\w+\s*=\s*\"[^\"]*\"", Pattern.CASE_INSENSITIVE),
# 扩展功能模块
        // Matches JavaScript event handler attributes with single quotes
        Pattern.compile("on\w+\s*=\s*\'[^\']*\'", Pattern.CASE_INSENSITIVE),
        // Matches JavaScript event handler attributes without quotes
        Pattern.compile("on\w+\s*=\s*([^\'\">]+)