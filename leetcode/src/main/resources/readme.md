
## Code FileName
``$!velocityTool.camelCaseName(${question.title})$!velocityTool.smallCamelCaseName(${question.titleSlug})``

## Code Template
```java
/**
 * @Title: ${question.frontendQuestionId}.${question.title}
 * @TitleSlug: $!velocityTool.smallCamelCaseName(${question.titleSlug})
 * @Author: Neo
 * @Date: $!velocityTool.date()
 */
package leetcode.editor.cn;
public class $!velocityTool.camelCaseName(${question.title})$!velocityTool.smallCamelCaseName(${question.titleSlug}){
public static void main(String[] args) {
        //测试代码
        //Solution solution = new $!velocityTool.camelCaseName(${question.title})$!velocityTool.smallCamelCaseName(${question.titleSlug})().new Solution();
    }
    ${question.code}
}
       
```

```python
"""
Title: ${question.frontendQuestionId}.${question.title}
Title Slug: $!velocityTool.smallCamelCaseName(${question.titleSlug})
Author: Neo
Date: $!velocityTool.date()
"""

${question.code}

```

