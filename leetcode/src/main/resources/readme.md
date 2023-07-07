
## Code FileName
``$!velocityTool.camelCaseName(${question.title})``

## Code Template
```java
/**
 * @Title: ${question.frontendQuestionId}.${question.title}
 * @TitleSlug: $!velocityTool.smallCamelCaseName(${question.titleSlug})
 * @Author: Neo
 * @Date: $!velocityTool.date()
 */
package leetcode.editor.cn;
public class $!velocityTool.camelCaseName(${question.title}){
public static void main(String[] args) {
        //测试代码
        Solution solution = new $!velocityTool.camelCaseName(${question.title})().new Solution();
    }
    ${question.code}
}
        
        
```